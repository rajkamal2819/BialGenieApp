package com.Hackathon.bialgenieapp.Actvities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityHotelsBinding;

import java.net.URL;
import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    ActivityHotelsBinding binding;
    private String JsonResponseLink = "https://hotels4.p.rapidapi.com/locations/v2/search?query=bangalore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_hotels);

        AllFlightAsyncTask task = new AllFlightAsyncTask();
        task.execute();


    }

    private class AllFlightAsyncTask extends AsyncTask<URL, Void, ArrayList<RestaurantShoppingModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<RestaurantShoppingModel> doInBackground(URL... urls) {
            ArrayList<RestaurantShoppingModel> event = HotelsQuery.fetchHotelsResults(JsonResponseLink);            //also we can use  urls[0]
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<RestaurantShoppingModel> event) {

          //  binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                Log.i("AllFlights", "NULL EVENT");
               // binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }

           // updateUi(event);

        }

    }

}