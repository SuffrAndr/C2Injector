package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Column {

    private Long   id;

    private String columnid;
    private String columnname;
    private String parentid;
    private double order;
    private String extensionfield1;

    private Date   updateTime = new Date();
}
