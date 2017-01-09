package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

import com.miri.blephone.mediainjector.db.DBConstans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Poster {

    private Long    id;

    private String  originalid;

    private short   type;

    private String  imageid;
    private String  filename;
    private String  resolution;
    private Integer imgtype;
    private Integer filesize;
    private String  imghash;

    private Date    initalTime = new Date();

    private String  objectId;

    private short   status     = DBConstans.PosterStatus.NOT_DOWNLOAD;

    public static interface PosterType {
        short CATEGORY = 0;
        short CLIP     = 1;
    }
}
