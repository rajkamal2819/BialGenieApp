package com.Hackathon.bialgenieapp.Fragments.restaurants;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.RestaurantAdapter;
import com.Hackathon.bialgenieapp.Models.RestaurantsModel;
import com.Hackathon.bialgenieapp.Queries.RestaurantQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentPostSecurityResBinding;

import java.net.URL;
import java.util.ArrayList;

public class PostSecurityRes extends Fragment {

    public PostSecurityRes() {
        // Required empty public constructor
    }

    FragmentPostSecurityResBinding binding;
    private String JsonResponseLink = "https://springboot-crud-rest-api.azurewebsites.net/restaurants";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostSecurityResBinding.inflate(getLayoutInflater());

        RestaurantAsyncTask task = new RestaurantAsyncTask();
        task.execute();

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<RestaurantsModel> restaurantList){

        if (restaurantList.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        RestaurantAdapter flightAdapter = new RestaurantAdapter(restaurantList, binding.recyclerView, getContext());
        binding.recyclerView.setAdapter(flightAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        flightAdapter.notifyDataSetChanged();

    }

    private class RestaurantAsyncTask extends AsyncTask<URL, Void, ArrayList<RestaurantsModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<RestaurantsModel> doInBackground(URL... urls) {
            ArrayList<RestaurantsModel> event = RestaurantQuery.fetchRestaurantData(JsonResponseLink,2);            //also we can use  urls[0]
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<RestaurantsModel> event) {

             binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                Log.i("AllFlights", "NULL EVENT");
                // binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }

            updateUi(event);

        }

    }

}