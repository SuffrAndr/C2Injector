package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends Page {

    private Long   id;

    private String assetid;
    private String originalid;
    private String baseId;
    private String assetpath;
    private String fstname;
    private int    fstlvlid;
    private String extag;
    private String clipname;
    private String othernme;
    private String keyword;
    private String director;
    private String adaptor;
    private String leader;
    private String kind;
    private String area;
    private String language;
    private String caption;
    private String tags;
    private String story;
    private String awards;
    private int    year;
    private int    duration;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   updatetime;
    private Date   createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   relasetime;
    private Date   playtime;
    private String inital;
    private String fullspell;
    private String simplespell;
    private int    serialcount;
    private int    productid;
    private String producername;
    private String channel;
    private String countrycode;
    private int    canDown;
    private int    filmorsingleset;
    private String periods;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   initalTime = new Date();

    private int    status     = NumberUtils.INTEGER_ONE;

    private String objectId;
}
