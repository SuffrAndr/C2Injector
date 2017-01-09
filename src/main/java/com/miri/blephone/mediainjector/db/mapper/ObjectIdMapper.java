package com.miri.blephone.mediainjector.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.ObjectId;

public interface ObjectIdMapper {

    ObjectId  query(@Param(value="currDate")final String date, @Param(value="type")final int type);

    void add(final ObjectId objectId);

    void update(final ObjectId objectId);
}
