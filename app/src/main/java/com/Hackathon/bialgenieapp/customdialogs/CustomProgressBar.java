package com.Hackathon.bialgenieapp.customdialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.Hackathon.bialgenieapp.R;

public class CustomProgressBar {
    static Activity activity;
    static AlertDialog alertDialog;

    public CustomProgressBar(Activity activity){
        this.activity=activity;
    }

    public static void startLoading(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);

        LayoutInflater inflater=activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog_parking,null));
        builder.setCancelable(false);

        alertDialog=builder.create();
        alertDialog.show();
    }

   public static void dismissLoading(){
        alertDialog.dismiss();
    }
}
