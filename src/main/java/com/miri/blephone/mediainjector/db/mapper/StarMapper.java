package com.miri.blephone.mediainjector.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.Star;

public interface StarMapper {

    void add(final Star star);

    int countByStarlId(@Param(value="starid") final String starId);

    void update(final Star star);

    void delete(@Param(value="starid") final String starId);
}
