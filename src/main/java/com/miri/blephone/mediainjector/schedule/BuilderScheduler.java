package com.miri.blephone.mediainjector.schedule;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;

public class BuilderScheduler {

    private final GlobalConfig globalConfig = GlobalConfig.getInstance();

    protected String storeFile(final String originalid, final String action, final String msg) throws IOException {

        final DateTime dateTime = new DateTime();

        // TODO:保存文件
        final String fileName = String.format("%s-%s%s", originalid, StringUtils.lowerCase(action), ".xml");

        final String dirPath = String.format("%s/%s/%s/%s", dateTime.getYear(), dateTime.getMonthOfYear(),
                dateTime.getDayOfMonth(), dateTime.getHourOfDay());

        final File dirPathFile = new File(this.globalConfig.getString(ConfigConstants.IPTV.STORE_PATH), dirPath);

        if (!dirPathFile.exists()) {
            dirPathFile.mkdirs();
        }

        final File file = new File(dirPathFile, fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileUtils.write(file, msg, CharEncoding.UTF_8);

        return String.format("%s/%s", dirPath, fileName);
    }
}
