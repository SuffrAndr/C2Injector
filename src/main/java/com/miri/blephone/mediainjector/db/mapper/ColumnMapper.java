package com.miri.blephone.mediainjector.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.Column;

public interface ColumnMapper {

    void add(final Column column);

    int countByColumnId(@Param(value="columnid") final String columnid);

    void update(final Column column);

    void delete(@Param(value="columnid") final String columnid);
}
