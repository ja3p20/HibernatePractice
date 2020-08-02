package com.learning.hibernatetutorial.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parseDate(String dateString) throws ParseException {
        Date theDate = formatter.parse(dateString);
        return theDate;
    }

    public static String formatDate(Date dateOfBirth) {
        String result = null;

        if(dateOfBirth != null){
            result = formatter.format(dateOfBirth);
        }
        return result;

    }
}
