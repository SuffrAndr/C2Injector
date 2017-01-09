package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Correlation {

    private Long   id;

    private String columnid;
    private String assetid;
    private double order;
    private String extensionfield1;
    private String oriassetid;

    private Date   updateTime = new Date();
}
