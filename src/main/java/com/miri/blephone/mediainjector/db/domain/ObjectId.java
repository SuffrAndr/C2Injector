package com.miri.blephone.mediainjector.db.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectId {

    private Long   id;

    private int    type = ObjectType.SERIES;

    private String currDate;

    private int    serialNo;

    public static interface ObjectType {

        int SERIES  = 1;
        int PROGRAM = 2;
        int MOVIE   = 3;

        int PICTURE = 4;
    }
}
