package com.miri.blephone.mediainjector.uitls;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import com.miri.blephone.mediainjector.config.ConfigConstants;
import com.miri.blephone.mediainjector.config.GlobalConfig;
import com.miri.blephone.mediainjector.db.domain.Poster;
import com.miri.blephone.mediainjector.iptv.c2.adi.ADIElementConstants;
import com.miri.blephone.mediainjector.iptv.c2.adi.PropertyType;

public class PropsTypeUtils {

    public static List<PropertyType> buildPosterProps(final List<Poster> posters) {

        final List<PropertyType> propertyTypes = new ArrayList<>();

        final String imgUrl = GlobalConfig.getInstance().getString(ConfigConstants.MGTV.IMG_FTP_PREFIX);

        if (CollectionUtils.isNotEmpty(posters)) {
            int i = 1;
            for (final Poster poster : posters) {

                final String fileURL = UrlUtils.getUrl(imgUrl, poster.getFilename());
                final PropertyType propertyType = new PropertyType();
                propertyType.setName("PictureURL" + i++);
                propertyType.setValue(fileURL);
                propertyTypes.add(propertyType);
            }
        }
        return propertyTypes;
    }

    public static List<PropertyType> buildReserveProps() {

        final int len = 5;

        final List<PropertyType> propertyTypes = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            final PropertyType propertyType = new PropertyType();
            propertyType.setName(ADIElementConstants.RESERVE + (i + 1));
            propertyType.setValue(StringUtils.EMPTY);
            propertyTypes.add(propertyType);
        }
        return propertyTypes;
    }

    public static PropertyType buildPriceProps() {
        return PropsTypeUtils.buildPropertyType(ADIElementConstants.Price, String.valueOf(NumberUtils.INTEGER_ZERO));
    }

    public static PropertyType buildOrderNumber() {
        return PropsTypeUtils.buildPropertyType(ADIElementConstants.ORDERNUMBER, StringUtils.EMPTY);
    }

    public static PropertyType buildPropertyType(final String name, final String value) {

        final PropertyType propertyType = new PropertyType();
        propertyType.setName(name);
        propertyType.setValue(value);

        return propertyType;
    }
}
