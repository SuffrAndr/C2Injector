package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MQMsg {
    private Long   id;
    private String pushcode;
    private String storePath;
    private Date   storeTime;
    private short  assetType;
    private short  assetDesc;
    private short  assetOperation;
    private short  status;
    private int    feedbackStatus;
    private Date   feedbackTime;
    private String remark;
}
