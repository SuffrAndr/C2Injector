package com.miri.blephone.mediainjector.mq;

import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.client.Channel;

public class MQConsumerMessageListener implements ChannelAwareMessageListener {

    private static final Logger DLOG = LoggerFactory.getLogger(MQConsumerMessageListener.class);

    @Autowired
    private MsgDelegate         msgDelegate;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {

            final String msg = new String(message.getBody(), CharEncoding.UTF_8);

            MQConsumerMessageListener.DLOG.debug("Receive msg is {}", msg);

            if (StringUtils.isNotBlank(msg)) {
                final boolean handleFlag = this.msgDelegate.storeMQMsg(msg);

                MQConsumerMessageListener.DLOG.debug("Process result is {}", handleFlag);

                // 回复消息
                if (handleFlag) {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                }
            }
        }
        catch (final Exception e) {
            MQConsumerMessageListener.DLOG.error("Process mq fail.", e);
        }
    }
}
