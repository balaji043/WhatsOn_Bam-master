package com.eventionlab.events.Model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Balaji on 28-12-2017.
 */

public class GetDate {

    public static String getDate(long milliSeconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
