package com.miri.blephone.mediainjector.db.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.miri.blephone.mediainjector.db.domain.File;

public interface FileMapper {

    void add(final File file);

    File queryByOriginalId(@Param(value = "originalId") final String originalId);

    void updateByOriginalId(final File file);

    List<File> queryByStatus(@Param(value = "status") final int status);

    List<File> queryExpireFiles();

    List<File> queryByOripartId(@Param(value = "oripartid") final String oripartId);

    List<File> queryByFileformatdesc(@Param(value = "oripartid") final String oripartId,
            @Param(value = "fileformatdesc") final int fileformatdesc,
            @Param(value = "createtime") final Date createtime);

    void updateStatusByOriginalId(@Param(value = "originalid") final String originalId,
            @Param(value = "status") final int status);

    void updateStatusAndDownloadStatusByOriginalId(@Param(value = "originalid") final String originalId,
            @Param(value = "status") final int status, @Param(value = "downloadStatus") final int downloadStatus);

    void updateDownloadStatusByOriginalId(@Param(value = "originalid") final String originalId,
            @Param(value = "downloadStatus") final int downloadStatus);

    void updateStatusByObjectId(@Param(value = "objectId") final String objectId,
            @Param(value = "status") final int status);

    List<File> queryFiles(File file);

    int queryFilesCount(File file);
}
