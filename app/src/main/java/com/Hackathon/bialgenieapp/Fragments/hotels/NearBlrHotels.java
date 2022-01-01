package com.Hackathon.bialgenieapp.Fragments.hotels;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Actvities.Hotels.HotelSearchResults;
import com.Hackathon.bialgenieapp.Adapters.HotelsItemAdapter;
import com.Hackathon.bialgenieapp.Models.HotelsModel;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentNearBlrHotelsBinding;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NearBlrHotels extends Fragment {

    public NearBlrHotels() {
        // Required empty public constructor
    }

    FragmentNearBlrHotelsBinding binding;
    private String JsonResponse = "https://hotels4.p.rapidapi.com/properties/list?destinationId=678196&pageSize=15&checkIn=";
    private String tempJsonResponse = "";

    /**
     *https://hotels4.p.rapidapi.com/properties/list?destinationId=678196&pageNumber=1&pageSize=25
     * &checkIn=2022-01-08&checkOut=2022-01-15&adults1=1&sortOrder=PRICE&locale=en_US&currency=USD
     */

    String checkInDate, checkOutDate;
    int pageCount = 1;
    private String LOG_TAG = NearBlrHotels.class.getSimpleName();
    ArrayList<HotelsModel> hotelsModelsList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNearBlrHotelsBinding.inflate(getLayoutInflater());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);

        checkInDate = year + "-" + month + "-" + day;
        LocalDate d1 = LocalDate.parse(checkInDate);
        LocalDate d2 = d1.plusDays(10);
        checkOutDate = d2.toString();

        JsonResponse += checkInDate + "&checkOut=" + checkOutDate + "&adults1=1&sortOrder=PRICE&locale=en_US&currency=USD&pageCount=";
        tempJsonResponse = JsonResponse;
        JsonResponse += pageCount;

        HotelsAsyncTask task = new HotelsAsyncTask();
        task.execute();

        binding.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()){
                    // binding.progressSpineer.setVisibility(View.VISIBLE);
                    binding.progressBar2.setVisibility(View.VISIBLE);

                    pageCount++;
                    JsonResponse = tempJsonResponse;
                    JsonResponse += pageCount;
                    MoreHotelsAsyncTask task1 = new MoreHotelsAsyncTask();
                    task1.execute();

                }
            }
        });


        return binding.getRoot();
    }

    public void updateUi(ArrayList<HotelsModel> hotelsList){

        hotelsModelsList = hotelsList;

        if (hotelsList.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        HotelsItemAdapter adapter = new HotelsItemAdapter(hotelsList, binding.recyclerView, getContext());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();

    }

    private class HotelsAsyncTask extends AsyncTask<URL, Void, ArrayList<HotelsModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<HotelsModel> doInBackground(URL... urls) {

            ArrayList<HotelsModel> event = HotelsQuery.fetchHotelsResults(JsonResponse);            //also we can use  urls[0]
            Log.i(LOG_TAG,"Link: "+JsonResponse);
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<HotelsModel> event) {

            binding.progressBar1.setVisibility(View.GONE);

            if (event == null) {
                Log.i(LOG_TAG, "NULL EVENT");
                // binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }
            updateUi(event);
        }

    }

    private class MoreHotelsAsyncTask extends AsyncTask<URL, Void, ArrayList<HotelsModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<HotelsModel> doInBackground(URL... urls) {
            ArrayList<HotelsModel> event = HotelsQuery.fetchHotelsResults(JsonResponse);
            Log.i(LOG_TAG,"Link: "+JsonResponse);
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<HotelsModel> event) {

            //  binding.loadingSpinner.setVisibility(View.GONE);
            binding.progressBar2.setVisibility(View.GONE);

            if (event == null) {
                binding.emptyTextView.setText("No Hotels Found");
                return;
            }

            hotelsModelsList.addAll(event);
            updateUi(hotelsModelsList);

        }
    }

}