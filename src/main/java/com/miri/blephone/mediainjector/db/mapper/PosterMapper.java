package com.miri.blephone.mediainjector.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.Poster;

public interface PosterMapper {

    void add(final Poster poster);

    int countByOriginalId(@Param(value="originalId") final String originalId);

    void updateByOriginalId(final Poster poster);

    List<Poster> queryByByOriginalId(@Param(value="originalId") final String originalId, @Param(value="type") final short type);

    List<Poster> queryInectByOriginalId(@Param(value="originalId") final String originalId, @Param(value="type") final short type);
}
