package com.sain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date StringToDate(String date){
        Date d = null;
        try {
            d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return d;
    }

}
