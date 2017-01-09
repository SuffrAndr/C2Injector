package com.miri.blephone.mediainjector.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.Category;

public interface CategoryMapper {

    void add(final Category category);

    int countByOriginalId(@Param(value = "originalId") final String originalId);

    void updateByOriginalId(final Category category);

    Category queryByOriginalId(@Param(value = "originalId") final String originalId);

    List<Category> querySeriesByStatus(@Param(value = "status") final int status);

    List<Category> queryMovicesByStatus(@Param(value = "status") final int status);

    List<Category> queryCategorys(Category category);

    int queryCategorysCount(Category category);

    void updateStatusByOriginalId(@Param(value = "originalId") final String originalId,
            @Param(value = "status") final int status);

    void updateStatusByObjectId(@Param(value = "objectId") final String objectId,
            @Param(value = "status") final int status);
}
