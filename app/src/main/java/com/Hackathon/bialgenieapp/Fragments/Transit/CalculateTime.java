package com.Hackathon.bialgenieapp.Fragments.Transit;

public class CalculateTime {

    public static String getTimeFormat(int hour,int min){
      String hourNew=String.valueOf(hour);
      String minNew=String.valueOf(min);

        if (hour<10){
           hourNew="0"+hourNew;
        }

        if (min<10){
            minNew="0"+minNew;
        }

        if (hour<12){

            return Integer.parseInt(hourNew)%12+":"+minNew+" AM";
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
}
