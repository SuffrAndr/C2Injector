package com.miri.blephone.mediainjector.db.domain;

import java.util.Date;

@lombok.Getter
@lombok.Setter
public class Page {
    int  limit;
    int  offset;

    Date beginDate;
    Date endDate;

}
