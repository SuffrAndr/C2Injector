package com.miri.blephone.mediainjector.converter;

import com.google.common.collect.*;
import com.miri.blephone.mediainjector.config.*;
import com.miri.blephone.mediainjector.db.domain.*;
import com.miri.blephone.mediainjector.iptv.c2.adi.*;
import com.miri.blephone.mediainjector.uitls.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class FileConverter {

    private final GlobalConfig globalConfig = GlobalConfig.getInstance();

    public List<PropertyType> convert(final Clip clip, final File file) {

        final PropertyType type = new PropertyType();
        type.setName(ADIElementConstants.TYPE);
        type.setValue(String.valueOf(this.convertType(clip.getIsintact())));

        int transferType = this.globalConfig.getInt(ConfigConstants.MGTV.MEDIA_TRANSFERTYPE);

        String urlPrefix = file.getUrlPrefix();
        if (FileConverter.isSpecial(transferType)) {
            urlPrefix = this.globalConfig.getString(ConfigConstants.MGTV.MEDIA_FTP_PREFIX);
        }

        final String url = UrlUtils.getUrl(urlPrefix, file.getFilename());

        final PropertyType fileURL = new PropertyType();
        fileURL.setName(ADIElementConstants.FILE_URL);
        fileURL.setValue(url);

        // TODO:设置为TS格式
        final PropertyType systemLayer = new PropertyType();
        systemLayer.setName(ADIElementConstants.Movie.SYSTEMLAYER);
        // systemLayer.setValue("1");
        //
        // MGTV 都是H264，所以这里暂时直接硬编码
        // String videoformat = file.getVideoformat();
        // final PropertyType videoTypeProp = new PropertyType();
        // videoTypeProp.setName(ADIElementConstants.Movie.VIDEOTYPE);
        // videoTypeProp.setValue("1");

        return Lists.newArrayList(type, fileURL, systemLayer);
    }

    private int convertType(final int type) {

        if (type == 1) {
            return type;
        }
        else {
            return 2;
        }
    }

    private static boolean isSpecial(int transferType) {
        return transferType == ConfigConstants.Values.SPECIAL_TRANSFERTYPE;
    }
}
