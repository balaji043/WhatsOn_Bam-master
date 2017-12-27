package com.eventionlab.events.Model;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GetDate {

    public static String getDate(long milliSeconds, String dateFormat)
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
