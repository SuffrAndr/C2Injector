package com.miri.blephone.mediainjector.uitls;

import org.joda.time.*;

import java.text.*;
import java.util.*;

public class DateUtils {

    public static String getDate(final Date date) {

        final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");

        if (date != null) {
            return sdf.format(date);
        }
        else {
            return sdf.format(new Date());
        }
    }

    public static String getNowDateTime() {

        final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

        return sdf.format(DateTime.now().toDate());
    }

    public static String getEndDateTime() {

        final SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");

        return sdf.format(DateTime.now().plusYears(30).toDate());
    }

    public static String getReleaseDate(final Date date) {

        final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

        if (date != null) {
            return sdf.format(date);
        }
        else {
            return sdf.format(new Date());
        }
    }
}
