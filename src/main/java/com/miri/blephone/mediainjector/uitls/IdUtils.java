package com.miri.blephone.mediainjector.uitls;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Joiner;

public class IdUtils {

    /**
     * 创建产生的系统内部编码 32位编码：前4位：供应商编码，后4位版权方编码， 8位：对象类型编码 8位：时间 8位：流水号
     * @param cpCode 内容提供商编码 versionCode 版权方
     * @param objectType
     * @param objectId 为对象ID，16位包含(8位时间和8位流水号)
     * @return
     */
    public static String buildId(final String cpCode, final String versionCode, final String objectType,
            final String objectId) {

        return Joiner.on(StringUtils.EMPTY).join(cpCode, versionCode, objectType, objectId).toString();
    }

    /**
     * 创建产生的系统内部编码 32位编码：前4位：供应商编码，后4位版权方编码， 8位：对象类型编码 8位：时间 8位：流水号
     * @param cpCode 内容提供商编码 versionCode 版权方
     * @param objectType
     * @param now
     * @return
     */
    public static String buildObjectId(final int type, final String date, final int serialNo) {

        String sNo = String.valueOf(serialNo);
        if (sNo.length() < 7) {
            sNo = StringUtils.leftPad(sNo, 7, '0');
        }

        return Joiner.on(StringUtils.EMPTY).join(date, String.valueOf(type), sNo).toString();
    }
}
