package com.Hackathon.bialgenieapp.Fragments.shopping;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.RestaurantShoppingAdapter;
import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;
import com.Hackathon.bialgenieapp.Queries.ShoppingQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentInternationalShopsBinding;

import java.net.URL;
import java.util.ArrayList;

public class InternationalShops extends Fragment {

    public InternationalShops() {
        // Required empty public constructor
    }

    FragmentInternationalShopsBinding binding;
    private String JsonResponseLink = "https://springboot-crud-rest-api.azurewebsites.net/retails";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInternationalShopsBinding.inflate(getLayoutInflater());

        ShoppingAsyncTask task = new ShoppingAsyncTask();
        task.execute();

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<RestaurantShoppingModel> restaurantList){

        if (restaurantList.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        RestaurantShoppingAdapter adapter = new RestaurantShoppingAdapter(restaurantList, binding.recyclerView, getContext());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();

    }

    private class ShoppingAsyncTask extends AsyncTask<URL, Void, ArrayList<RestaurantShoppingModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<RestaurantShoppingModel> doInBackground(URL... urls) {
            ArrayList<RestaurantShoppingModel> event = ShoppingQuery.fetchShoppingResults(JsonResponseLink,2);            //also we can use  urls[0]
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