package com.miri.blephone.mediainjector.iptv.c2.handlers;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.handlers.LogHandler;
import org.apache.axis.utils.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * axis日志自定义打印
 * @author Night
 */
public class CustomLogHandler extends BasicHandler {

    private static final long serialVersionUID = 1389631152624686399L;

    protected static Logger   DLOG             = LoggerFactory.getLogger(LogHandler.class.getName());

    long                      start            = -1;

    /*
     * (non-Javadoc)
     * @see org.apache.axis.Handler#invoke(org.apache.axis.MessageContext)
     */
    @Override
    public void invoke(MessageContext msgContext) throws AxisFault {
        // CustomLogHandler.DLOG.debug("Enter: LogHandler::invoke");
        if (msgContext.getPastPivot() == false) {
            this.start = System.currentTimeMillis();
        }
        else {
            this.logMessages(msgContext);
        }
        // CustomLogHandler.DLOG.debug("Exit: LogHandler::invoke");
    }

    // 记录消息
    private void logMessages(MessageContext msgContext) throws AxisFault {
        try {
            // Message inMsg = msgContext.getRequestMessage();
            // Message outMsg = msgContext.getResponseMessage();

            // CustomLogHandler.DLOG.debug("=======================================================");
            // if (this.start != -1) {
            // CustomLogHandler.DLOG
            // .info("= " + Messages.getMessage("elapsed00", "" +
            // (System.currentTimeMillis() - this.start)));
            // }
            // CustomLogHandler.DLOG
            // .info("= " + Messages.getMessage("inMsg00", inMsg == null ? "null" :
            // inMsg.getSOAPPartAsString()));
            // CustomLogHandler.DLOG.debug(
            // "= " + Messages.getMessage("outMsg00", outMsg == null ? "null" :
            // outMsg.getSOAPPartAsString()));
            // CustomLogHandler.DLOG.debug("=======================================================");
        }
        catch (Exception e) {
            CustomLogHandler.DLOG.error(Messages.getMessage("exception00"), e);
            throw AxisFault.makeFault(e);
        }
    }

    @Override
    public void onFault(MessageContext msgContext) {
        try {
            this.logMessages(msgContext);
        }
        catch (AxisFault axisFault) {
            CustomLogHandler.DLOG.error(Messages.getMessage("exception00"), axisFault);
        }
    }
}
