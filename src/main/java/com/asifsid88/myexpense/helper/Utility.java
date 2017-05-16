package com.asifsid88.myexpense.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by mhussaa on 5/15/17.
 */
public final class Utility {

    public static String getCurrentTime() {
        final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(calendar.getTime());
    }
}
