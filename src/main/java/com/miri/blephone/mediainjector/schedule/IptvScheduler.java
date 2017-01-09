package com.miri.blephone.mediainjector.schedule;

import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;
import com.miri.blephone.mediainjector.db.DBConstans;
import com.miri.blephone.mediainjector.db.dao.DbRepository;
import com.miri.blephone.mediainjector.db.domain.ObjectId;
import com.miri.blephone.mediainjector.db.domain.WsMsg;
import com.miri.blephone.mediainjector.iptv.c2.req.CSPRequestServiceLocator;
import com.miri.blephone.mediainjector.iptv.c2.req.CSPResult;

@Service
public class IptvScheduler implements InitializingBean {

    private static final Logger DLOG         = LoggerFactory.getLogger(IptvScheduler.class);

    @Autowired
    private DbRepository        dbRepository;

    private final GlobalConfig  globalConfig = GlobalConfig.getInstance();

    CSPRequestServiceLocator    locator;

    private String              cspId;

    private String              lspId;

    @Scheduled(fixedRate = 50000)
    public void build() {

        final List<WsMsg> wsMsgs = this.dbRepository
                .queryWSMsgStaus(Lists.newArrayList(DBConstans.WsStatus.INIT, DBConstans.WsStatus.SEND_FAIL));

        for (final WsMsg wsMsg : wsMsgs) {

            final String cmdFileURL = this.globalConfig.getString(ConfigConstants.IPTV.FTP_PREFIX)
                    + wsMsg.getStorePath();

            IptvScheduler.DLOG.info("Post soap to iptv.cmdFileURL={}", cmdFileURL);

            int status = wsMsg.getStatus();
            int injectStatus = DBConstans.AssetStatus.INJECTED;
            String errorDesc = StringUtils.EMPTY;
            try {

                final CSPResult cspResult = this.locator.getctms().execCmd(this.cspId, this.lspId,
                        wsMsg.getCorrelateId(), cmdFileURL);

                status = wsMsg.getStatus();
                errorDesc = cspResult.getErrorDescription();

                IptvScheduler.DLOG.info("Post soap to iptv rst:status={}", cspResult.getResult());

                if (cspResult.getResult() == 0) {
                    status = DBConstans.WsStatus.SEND_SUCESS;
                }
                else {
                    status = DBConstans.WsStatus.SEND_FAIL;
                    injectStatus = DBConstans.WsStatus.INJECT_FAIL;
                }

            }
            catch (RemoteException | ServiceException e) {
                IptvScheduler.DLOG.error("Send soap's msg fial.", e);

                status = DBConstans.WsStatus.SEND_FAIL;
                injectStatus = DBConstans.AssetStatus.ADI_DEPLOYED;
                errorDesc = e.getMessage();
            }

            wsMsg.setUpdateTime(DateTime.now().toDate());
            wsMsg.setStatus(status);
            wsMsg.setErrorDesc(errorDesc);

            wsMsg.setRetryNumber((short) (NumberUtils.SHORT_ONE + wsMsg.getRetryNumber()));

            this.dbRepository.updateWSMsgStatus(wsMsg);

            int type = wsMsg.getType();
            if (type == ObjectId.ObjectType.SERIES) {
                this.dbRepository.updateSeriesStatusByObjectId(type, wsMsg.getObjectId(), injectStatus);
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.locator = new CSPRequestServiceLocator();
        this.locator.setctmsEndpointAddress(this.globalConfig.getString(ConfigConstants.IPTV.NOTIFY_URL));
        this.cspId = this.globalConfig.getString(ConfigConstants.IPTV.CSPID);
        this.lspId = this.globalConfig.getString(ConfigConstants.IPTV.LSPID);
    }
}
