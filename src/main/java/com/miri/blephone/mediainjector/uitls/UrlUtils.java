package com.miri.blephone.mediainjector.uitls;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

public final class UrlUtils {

    public static String getUrl(final String urlPrefix, final String fileNmae) {

        final StringBuilder builder = new StringBuilder();

        if (StringUtils.endsWith(urlPrefix, "/") && StringUtils.startsWith(fileNmae, "/")) {

            builder.append(urlPrefix).append(fileNmae.substring(NumberUtils.INTEGER_ONE));
        }

        if (StringUtils.endsWith(urlPrefix, "/") && !StringUtils.startsWith(fileNmae, "/")) {
            builder.append(urlPrefix).append(fileNmae);
        }

        if (!StringUtils.endsWith(urlPrefix, "/") && StringUtils.startsWith(fileNmae, "/")) {
            builder.append(urlPrefix).append(fileNmae);
        }

        if (!StringUtils.endsWith(urlPrefix, "/") && !StringUtils.startsWith(fileNmae, "/")) {
            builder.append(urlPrefix).append("/").append(fileNmae);
        }

        return builder.toString();
    }

    public static String getFileName(final String fileNmae) {

        final StringBuilder builder = new StringBuilder();

        if (StringUtils.startsWith(fileNmae, "/")) {

            builder.append(fileNmae.substring(NumberUtils.INTEGER_ONE));
        }

        return builder.toString();
    }
}
