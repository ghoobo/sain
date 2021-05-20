package com.sain.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        String str = "2020-05-20 23:32";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d1;
        try {
            d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str);
            System.out.println("DateTime d1>>>>>>: " + d1);
            String d2 = format.format(d1);
            System.out.println("DateTime d2>>>>>>: " + d2);
            Date d3;
            d3 = format.parse(d2);
            System.out.println("DateTime d3>>>>>>: " + format.format(d3));
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
