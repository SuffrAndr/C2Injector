package com.miri.blephone.mediainjector.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.Clip;

public interface ClipMapper {

    void add(final Clip clip);

    int countByOriginalId(@Param(value = "originalId") final String originalId);

    Clip queryByOriginalId(@Param(value = "originalId") final String originalId);

    void updateByOriginalId(final Clip clip);

    List<Clip> queryByStatus(@Param(value = "status") final int status);

    List<Clip> querySeriesByStatus(@Param(value = "clipStatus") final int clipStatus,
            @Param(value = "categoryStatus") final int categoryStatus);

    List<Clip> queryMovicesByStatus(@Param(value = "clipStatus") final int clipStatus,
            @Param(value = "categoryStatus") final int categoryStatus);

    List<Clip> queryByOriassetId(@Param(value = "oriassetid") final String oriassetId);

    Clip queryByObjectId(@Param(value = "objectId") final String objectId);

    void updateStatusByOriginalId(@Param(value = "originalid") final String originalId,
            @Param(value = "status") final int status);

    void updateStatusByObjectId(@Param(value = "objectId") final String objectId,
            @Param(value = "status") final int status);

    List<Clip> queryClips(Clip clip);

    int queryClipsCount(Clip clip);
}
