package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File extends Page {

    private Long    id;

    private String  fileid;
    private String  originalid;
    private String  entityfileid;
    private String  assetid;
    private String  oriassetid;
    private String  oripartid;
    private String  partid;
    private String  filename;
    private int     fileformatdesc;
    private long    filesize;
    private Integer filebitrate;
    private Integer fileduration;
    private String  fileformat;
    private short   is3D;
    private String  filehash;
    private String  videobitrate;
    private String  videoformat;
    private String  videoinfo;
    private String  videointroduction;
    private Integer videowidth;
    private Integer videoheight;
    private String  videoscale;
    private Integer videolength;
    private String  videosetcabac;
    private String  formatsetreframes;
    private String  framerate;
    private String  criterion;
    private String  vga;
    private String  colorimetry;
    private String  scantype;
    private String  datadensity;
    private String  encodedlibrary;
    private String  encodedlibset;
    private String  audioformat;
    private String  audioinfo;
    private String  audiointrodution;
    private String  audioversion;
    private String  audiomuxingmode;
    private Integer audioduration;
    private Integer audiotrack;
    private Integer audiosampling;
    private String  audioratemode;
    private String  filesource;
    private String  isdrm;
    private String  encryptsolution;
    private String  thirdfileid;
    private String  overallbitratemode;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    createtime;

    private int     status         = NumberUtils.INTEGER_ONE;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    initalTime     = new Date();

    private String  objectId;

    private int     downloadStatus = NumberUtils.INTEGER_ONE;

    private String  urlPrefix      = StringUtils.EMPTY;
}
