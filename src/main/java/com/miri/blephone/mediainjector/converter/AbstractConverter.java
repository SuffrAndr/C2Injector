package com.miri.blephone.mediainjector.converter;

import com.google.common.base.*;
import com.miri.blephone.mediainjector.uitls.*;
import org.apache.commons.lang.*;
import org.apache.commons.lang.math.NumberUtils;

import java.util.*;

public abstract class AbstractConverter {

    private static final String SEARCH_STR = " ";
    private static final String SUFFIX     = "|";

    protected String convertTags(final String tags) {

        final char searchChar = '|';
        if (StringUtils.contains(tags, searchChar)) {

            final List<String> strs = new ArrayList<>();

            final String[] splits = StringUtils.split(tags, searchChar);

            for (final String splitstr : splits) {
                if (StringUtils.isNotBlank(splitstr)) {
                    final String[] split2s = StringUtils.split(splitstr, '-');
                    if (split2s.length > 1) {
                        strs.add(split2s[0]);
                    }
                }
            }

            return Joiner.on(';').join(strs);
        }
        else {
            return tags;
        }
    }

    protected String convertType(String fstname) {

        String rst = "";

        if (StringUtils.equals("纪实", fstname)) {
            rst = PinyinUtils.getPinYinHeadChar("纪录片");
        }
        else if (StringUtils.equals("新闻纪实", fstname)) {
            rst = PinyinUtils.getPinYinHeadChar("新闻");
        }
        else if (StringUtils.equals("微电影", fstname)) {
            rst = PinyinUtils.getPinYinHeadChar("电影");
        }
        else {
            rst = PinyinUtils.getPinYinHeadChar(fstname);
        }

        return rst;
    }

    protected static String convertDuration(int duration) {

        String rst = "";

        if (duration != NumberUtils.INTEGER_ZERO.intValue()) {

            int a = duration / 60;
            rst = String.valueOf(a);
        }

        return rst;
    }

    protected static String convertArea(String area) {

        if (StringUtils.isBlank(area)) {
            return area;
        }

        String rst = StringUtils.trim(area);

        if (StringUtils.startsWith(rst, AbstractConverter.SUFFIX)
                && StringUtils.endsWith(rst, AbstractConverter.SUFFIX)) {
            rst = StringUtils.substringBeforeLast(rst, AbstractConverter.SUFFIX);
            rst = StringUtils.substringAfter(rst, AbstractConverter.SUFFIX);
        }

        if (StringUtils.contains(rst, AbstractConverter.SEARCH_STR)) {
            rst = StringUtils.replace(rst, AbstractConverter.SEARCH_STR, AbstractConverter.SUFFIX);
        }

        if (StringUtils.contains(rst, AbstractConverter.SEARCH_STR)) {
            rst = StringUtils.replace(rst, AbstractConverter.SEARCH_STR, AbstractConverter.SUFFIX);
        }

        if (StringUtils.equals(rst, "中国内地") || StringUtils.equals(rst, "内地") || StringUtils.equals(rst, "大陆")) {
            rst = "中国大陆";
        }

        if (StringUtils.equals(rst, "香港")) {
            rst = "中国香港";
        }

        if (StringUtils.equals(rst, "港台")) {
            rst = "中国香港|中国台湾";
        }

        if (StringUtils.equals(rst, "港澳台")) {
            rst = "中国香港|中国澳门|中国台湾";
        }

        return rst;
    }

    protected static String convertDirector(String director) {

        if (StringUtils.isBlank(director)) {
            return director;
        }

        String rst = StringUtils.trim(director);

        if (StringUtils.startsWith(rst, AbstractConverter.SUFFIX)
                && StringUtils.endsWith(rst, AbstractConverter.SUFFIX)) {
            rst = StringUtils.substringBeforeLast(rst, AbstractConverter.SUFFIX);
            rst = StringUtils.substringAfter(rst, AbstractConverter.SUFFIX);
        }

        if (StringUtils.startsWith(rst, AbstractConverter.SUFFIX)) {
            rst = StringUtils.substringAfter(rst, AbstractConverter.SUFFIX);
        }

        if (StringUtils.endsWith(rst, AbstractConverter.SUFFIX)) {
            rst = StringUtils.substringBeforeLast(rst, AbstractConverter.SUFFIX);
        }

        if (StringUtils.equals(rst, "无") || StringUtils.equals(rst, "不详") || StringUtils.equals(rst, "暂无")
                || StringUtils.equals(rst, "未知")) {
            rst = "暂无";
        }

        if (StringUtils.equals(rst, "0")) {
            rst = "暂无";
        }

        return rst;
    }

    protected static String convertKind(String kind) {

        if (StringUtils.isBlank(kind)) {
            return kind;
        }

        String rst = StringUtils.trim(kind);

        if (StringUtils.startsWith(rst, AbstractConverter.SUFFIX)
                && StringUtils.endsWith(rst, AbstractConverter.SUFFIX)) {
            rst = StringUtils.substringBeforeLast(rst, AbstractConverter.SUFFIX);
            rst = StringUtils.substringAfter(rst, AbstractConverter.SUFFIX);
        }

        return rst;
    }


    protected static int convertDefinition(int fileformatdesc) {

        int  definition;

        switch (fileformatdesc)
        {
            case 0:
                definition = 0;
                break;
            case 1:
                definition = 0;
                break;
            case 2:
                definition = 1;
                break;
            case 3:
                definition = 2;
                break;
            case 9:
                definition = 3;
                break;
	        default:
		        definition = 0;
		        break;
        }

        return definition;
    }

    public static void main(final String[] args) {

        String area = "董洁|贾静雯梅婷|冉莹颖|";

        String rst = AbstractConverter.convertDirector(area);

        System.out.println(rst);

    }
}
