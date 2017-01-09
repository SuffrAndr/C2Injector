package com.miri.blephone.mediainjector.schedule;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.MQMsg;
import com.miri.blephone.mediainjector.mq.MsgDelegate;

@Service
public class DbMsgProcesser implements InitializingBean {

    private static final Logger DLOG = LoggerFactory.getLogger(DbMsgProcesser.class);

    @Autowired
    private DbRepository        dbRepository;

    @Autowired
    MsgDelegate                 msgDelegate;

    public void process() throws Exception {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                while (true) {
                    try {

                        List<MQMsg> processMQMsg = DbMsgProcesser.this.dbRepository
                                .queryMqMsgByStatus(DBConstans.MQMsgStatus.PROCESSING);

                        for (MQMsg mQMsg : processMQMsg) {

                            DbMsgProcesser.DLOG.info("Process db msg {}", mQMsg.getPushcode());

                            DbMsgProcesser.this.msgDelegate.handle(mQMsg);

                            Thread.sleep(100L);
                        }

                        Thread.sleep(1000L);

                    }
                    catch (Exception e) {
                        DbMsgProcesser.DLOG.error("Process db msg.", e);
                    }
                }
            }
        });

        thread.setDaemon(true);
        thread.setName("DbMsgProcesser");
        thread.start();

        DbMsgProcesser.DLOG.info("Start db processer");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.process();
    }
}
