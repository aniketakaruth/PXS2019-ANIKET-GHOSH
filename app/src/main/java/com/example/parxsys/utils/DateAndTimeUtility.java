package com.example.parxsys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateAndTimeUtility {


    public static Double getTimeDiffrenceInHours(String startTime, String endTime) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        long diffHours=0L;
        try {
           Date start = format.parse(startTime);
            Date end = format.parse(endTime);
            long difference = end.getTime() - start.getTime();
            diffHours = difference / (60 * 60 * 1000) % 24;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return Double.parseDouble(String.valueOf(diffHours));
    }


    public static String getDate(String day) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(day);
        String newstr = new SimpleDateFormat("dd MM yyyy").format(date);
        return newstr;
    }
}
