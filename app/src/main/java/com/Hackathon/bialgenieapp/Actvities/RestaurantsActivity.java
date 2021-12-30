package com.Hackathon.bialgenieapp.Actvities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Models.RestaurantsModel;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.Queries.RestaurantQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityRestaurantsBinding;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.URL;
import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    ActivityRestaurantsBinding binding;
    private String JsonResponseLink = "https://spring-rest-api.azurewebsites.net/restaurants";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RestaurantAsyncTask task = new RestaurantAsyncTask();
        task.execute();

    }

    private class RestaurantAsyncTask extends AsyncTask<URL, Void, ArrayList<RestaurantsModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<RestaurantsModel> doInBackground(URL... urls) {
            ArrayList<RestaurantsModel> event = RestaurantQuery.fetchRestaurantData(JsonResponseLink);            //also we can use  urls[0]
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<RestaurantsModel> event) {

           // binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                Log.i("AllFlights", "NULL EVENT");
               // binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }

           // updateUi(event);

        }

    }

}