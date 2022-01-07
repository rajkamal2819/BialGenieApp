package com.Hackathon.bialgenieapp;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.Hackathon.bialgenieapp.Database.ParkingChargesDatabase;
import com.Hackathon.bialgenieapp.Models.ParkingDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAsyncTask extends AsyncTask<Void,Void, List<ParkingDetails>> {

   List<ParkingDetails> list=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override

    protected List<ParkingDetails> doInBackground(Void... voids) {
        try {
            list=ParkingChargesDatabase.getDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
