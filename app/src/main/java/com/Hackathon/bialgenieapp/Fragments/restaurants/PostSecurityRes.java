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

import com.Hackathon.bialgenieapp.Adapters.RestaurantShoppingAdapter;
import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;
import com.Hackathon.bialgenieapp.Queries.RestaurantQuery;
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

    protected void updateUi(ArrayList<RestaurantShoppingModel> restaurantList){

        if (restaurantList.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        RestaurantShoppingAdapter flightAdapter = new RestaurantShoppingAdapter(restaurantList, binding.recyclerView, getContext());
        binding.recyclerView.setAdapter(flightAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        flightAdapter.notifyDataSetChanged();

    }

    private class RestaurantAsyncTask extends AsyncTask<URL, Void, ArrayList<RestaurantShoppingModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<RestaurantShoppingModel> doInBackground(URL... urls) {
            ArrayList<RestaurantShoppingModel> event = RestaurantQuery.fetchRestaurantData(JsonResponseLink,2);            //also we can use  urls[0]
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<RestaurantShoppingModel> event) {

             binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                // binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }

            updateUi(event);

        }

    }

}