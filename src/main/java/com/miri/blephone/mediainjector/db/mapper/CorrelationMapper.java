package com.miri.blephone.mediainjector.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.Correlation;

public interface CorrelationMapper {

    void add(final Correlation correlation);

    int countByCorrelation(@Param(value="columnid") final String columnid, @Param(value="oriassetid") final String oriassetid);

    void update(final Correlation correlation);

    void delete(@Param(value="columnid") final String columnid, @Param(value="oriassetid") final String oriassetid);
}
