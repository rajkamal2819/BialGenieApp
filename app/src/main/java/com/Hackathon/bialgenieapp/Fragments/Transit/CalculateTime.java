package com.Hackathon.bialgenieapp.Fragments.Transit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalculateTime {
    private static int days,hours,min;

    public static int getDays() {
        return days;
    }

    public static int getHours() {
        return hours;
    }

    public static int getMin() {
        return min;
    }

    public static String getTimeFormat(int hour, int min){
      String hourNew=String.valueOf(hour);
      String minNew=String.valueOf(min);

        if (hour<10){
           hourNew="0"+hourNew;
        }

        if (min<10){
            minNew="0"+minNew;
        }

        if (hour<12){

            return Integer.parseInt(hourNew)+":"+minNew+" AM";
        }
        else if(hour==12){
            return Integer.parseInt(hourNew)+":"+minNew+" PM";
        }
        else if(hour==24){
            return Integer.parseInt(hourNew)+":"+minNew+" AM";
        }
        else{
            return  Integer.parseInt(hourNew)%12+":"+minNew+" PM";
        }



    }

    public static void getTimeDiff(String date,String time) throws ParseException {
        String form=date+" "+time;
        Date dateNew=new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.ENGLISH).parse(form);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateCurrent = new Date();
        System.out.println(formatter.format(dateCurrent));

        long diff=dateCurrent.getTime()-dateNew.getTime();

        days = (int) (diff / (1000*60*60*24));
        hours = (int) ((diff - (1000*60*60*24*days)) / (1000*60*60));
        min = (int) (diff - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);
    }
}
