package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.miri.blephone.mediainjector.db.DBConstans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WsMsg {
    private Long   id;
    private String correlateId;
    private String storePath;
    private String errorDesc;
    private String resultFileUrl;
    private String notifyRrrorDesc;

    private Date   initalTime  = new Date();
    private Date   updateTime  = new Date();
    private int    status      = DBConstans.WsStatus.INIT;
    private short  retryNumber;

    private String objectId;

    private int    type;

    private int    opType;

    private String subObjectId = StringUtils.EMPTY;
}
