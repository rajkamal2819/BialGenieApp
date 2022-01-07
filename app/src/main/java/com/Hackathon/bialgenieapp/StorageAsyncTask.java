package com.Hackathon.bialgenieapp;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.Hackathon.bialgenieapp.Database.ParkingChargesDatabase;
import java.io.IOException;

public class StorageAsyncTask extends AsyncTask<String,Void,Void> {


    @Override
    protected Void doInBackground(String... strings) {
        try {
            ParkingChargesDatabase.insertEntity(strings[0],strings[1],strings[2],strings[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


