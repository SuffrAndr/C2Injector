package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clip extends Page {

    private Long    id;

    private String  assetid;
    private String  oriassetid;
    private String  partid;
    private String  originalid;
    private String  partname;
    private String  othernme;
    private String  extag;
    private String  eventtag;
    private String  keyword;
    private String  director;
    private String  adaptor;
    private String  leader;
    private String  kind;
    private String  area;
    private String  language;
    private String  caption;
    private String  tags;
    private String  story;
    private String  awards;
    private Integer year;
    private int     duration;
    private Date    updatetime;
    private Date    createtime;
    private Date    relasetime;
    private String  inital;
    private String  simplespell;
    private int     isintact;
    private int     serialno;
    private String  publisher;
    private String  periods;
    private int     status     = NumberUtils.INTEGER_ONE;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    initalTime = new Date();

    private String  objectId;
}
