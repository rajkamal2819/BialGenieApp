package com.Hackathon.bialgenieapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;

public class CalculateCharges {


    public static int totalCharge(int days,int hours,int mins,String carType,Context context){

        SharedPreferences sumPreference=context.getSharedPreferences("sum",Context.MODE_PRIVATE);
        int sum=0;


        if (carType.equals("Two Wheeler Parking")) {
            sum+=hours*20+20;

            if (days>=1)
                sum+=days*150+100;
        }

        if(carType.equals("Car Parking") || carType.equals("Parking for reduced mobility")){
            sum+=hours*50+50;

            if (days>=1)
                sum+=days*350+250;
        }

        if (carType.equals("Bus parking-Below 16")){
            sum+=hours*200;
        }

        if (carType.equals("Bus parking-Above 16")){
            sum+=hours*500;
        }



        SharedPreferences.Editor editor=sumPreference.edit();
        editor.putInt("sum",sum);
        editor.apply();

       return sumPreference.getInt("sum",Context.MODE_PRIVATE);
    }
}
