package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Star {

    private Long   id;

    private String starid;
    private String name;
    private String ename;
    private String sex;
    private Date   birthday;
    private String homeplace;
    private String college;
    private String nation;
    private String constellathion;
    private String blood;
    private double height;
    private double weight;
    private String intro;
    private String initial;
    private String photourl;
    private String imghash;
    private String fullspell;
    private String simplespell;
    private String occupation;

    private Date   updateTime = new Date();
}
