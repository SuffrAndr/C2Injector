package com.miri.blephone.mediainjector.uitls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;

public final class PinyinUtils {

    /**
     * 获取拼音首字母
     * @param str 中文字符
     * @return 汉语首字母
     */
    public static String getPinYinHeadChar(String str) {
        if (str != null) {
            final StringBuffer convert = new StringBuffer();
            for (int j = 0; j < str.length(); j++) {
                final char word = str.charAt(j);

                final String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
                if (pinyinArray != null) {
                    convert.append(pinyinArray[0].charAt(0));
                }
                else {
                    convert.append(word);
                }
            }
            return convert.toString();
        }
        else {
            return str;
        }

    }

    /**
     * 获取字符串的首字母(包含多音字)的字符串组合
     * @param str 当前需要转换的字符串
     * @param space 分隔符
     * @return String 以 space 分隔 返回值
     */
    public static String getDuoYinZiPinYinHeadChar(String str, String space) {
        String resStr = null;
        final List<String> resList = PinyinUtils.getDuoYinZiPinYinHeadChar(str);
        if (resList != null) {
            resStr = StringUtils.arrayToDelimitedString(resList.toArray(), space);
        }
        return resStr;
    }

    /**
     * 获取拼音首字母(包含多音字)
     * @param str 当前需要转换的字符串
     * @return List<String> 返回值
     */
    public static List<String> getDuoYinZiPinYinHeadChar(String str) {

        List<String> resList = null;
        List<String> tempList = null;
        List<List<String>> pinYinList = null;

        if (str != null) {

            // 获取当前传入的非空字符串的汉语拼音串
            pinYinList = new ArrayList<List<String>>();
            for (int j = 0; j < str.length(); j++) {
                final char word = str.charAt(j);
                final String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
                List<String> newList = null;
                if (pinyinArray != null) {

                    // 合并首字母相同的多音字的首字母
                    final Set<String> set = new HashSet<String>();
                    for (final String string : pinyinArray) {
                        set.add(string.charAt(0) + "");
                    }

                    newList = new ArrayList<String>(set);
                    pinYinList.add(newList);
                }
                else {
                    newList = new ArrayList<String>();
                    newList.add(word + "");
                    pinYinList.add(newList);
                }
            }

            // 开始组装拼音首字母
            if (pinYinList != null && !pinYinList.isEmpty()) {

                resList = new ArrayList<String>();
                tempList = new ArrayList<String>();

                for (int j = 0; j < pinYinList.size(); j++) {
                    final List<String> strings = pinYinList.get(j);
                    if (strings != null && !strings.isEmpty()) {
                        if (j == 0) {
                            for (int k = 0; k < strings.size(); k++) {
                                resList.add(strings.get(k) + "");
                            }
                        }
                        else {
                            for (int k = 0; k < strings.size(); k++) {
                                for (final String string1 : resList) {
                                    tempList.add(string1.concat(strings.get(k) + ""));
                                }
                            }

                            resList.clear();
                            for (final String string : tempList) {
                                resList.add(string);
                            }
                            tempList.clear();
                        }
                    }

                }

            }
        }
        return resList;
    }

}
