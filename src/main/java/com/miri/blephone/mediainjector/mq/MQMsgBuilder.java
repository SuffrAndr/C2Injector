package com.miri.blephone.mediainjector.mq;

import org.joda.time.DateTime;

import com.miri.blephone.mediainjector.db.domain.MQMsg;

public class MQMsgBuilder {

    public static MQMsg buildMQMsg(final String storePath, final short assetType, final short assetDesc,
            final short assetOperation, final String pushcode) {
        MQMsg mQMsg;
        mQMsg = new MQMsg();
        mQMsg.setAssetDesc(assetDesc);
        mQMsg.setAssetOperation(assetOperation);
        mQMsg.setAssetType(assetType);
        mQMsg.setStorePath(storePath);
        mQMsg.setStoreTime(DateTime.now().toDate());
        mQMsg.setPushcode(pushcode);
        mQMsg.setStatus((short) 1);
        return mQMsg;
    }
}
