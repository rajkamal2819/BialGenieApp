package com.Hackathon.bialgenieapp.Actvities.Hotels;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.Hackathon.bialgenieapp.Adapters.HotelsItemAdapter;
import com.Hackathon.bialgenieapp.Adapters.RestaurantShoppingAdapter;
import com.Hackathon.bialgenieapp.Models.HotelsModel;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityHotelSearchResultsBinding;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class HotelSearchResults extends AppCompatActivity {

    ActivityHotelSearchResultsBinding binding;
    private String JsonLocationResponse = "https://hotels4.p.rapidapi.com/locations/v2/search?query=";
    private String JsonHotelResponseStart = "https://hotels4.p.rapidapi.com/properties/list?destinationId=";
    private String tempJsonResponseStart = "https://hotels4.p.rapidapi.com/properties/list?destinationId=";
    private static String jsonHotelFinalLink = "";
    //pageNumber=2&pageSize=25&checkIn=2022-01-08&checkOut=2022-01-15&adults1&sortOrder=PRICE

    String checkInDate, checkOutDate, location, adults;
    int pageCount = 1;
    private String LOG_TAG = HotelSearchResults.class.getSimpleName();
    ArrayList<HotelsModel> hotelsModelsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelSearchResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         hotelsModelsList = new ArrayList<>();

         checkInDate = getIntent().getStringExtra("checkInDate");
         checkOutDate = getIntent().getStringExtra("checkOutDate");
         location = getIntent().getStringExtra("location");
         adults = getIntent().getStringExtra("adults");

         JsonLocationResponse += location;
         HotelsAsyncTask task = new HotelsAsyncTask();
         task.execute();

        binding.nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()){
                    // binding.progressSpineer.setVisibility(View.VISIBLE);
                    binding.progressBar2.setVisibility(View.VISIBLE);

                    pageCount++;
                    jsonHotelFinalLink = tempJsonResponseStart;
                    jsonHotelFinalLink += pageCount;
                    MoreHotelsAsyncTask task1 = new MoreHotelsAsyncTask();
                    task1.execute();

                }
            }
        });

    }

    public void updateUi(ArrayList<HotelsModel> hotelsList){

        hotelsModelsList = hotelsList;

        if (hotelsList.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        HotelsItemAdapter adapter = new HotelsItemAdapter(hotelsList, binding.recyclerView, getApplicationContext());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter.notifyDataSetChanged();

    }

    private class HotelsAsyncTask extends AsyncTask<URL, Void, ArrayList<HotelsModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<HotelsModel> doInBackground(URL... urls) {
            String locationId = HotelsQuery.getLocationId(JsonLocationResponse);
            Log.i(LOG_TAG,locationId);

            /**
             * https://hotels4.p.rapidapi.com/properties/list?destinationId=678196&pageNumber=
             * 1&pageSize=25&checkIn=2022-01-08&checkOut=2022-01-15&adults1=1&sortOrder=PRICE&locale=en_US&currency=USD
             */

            JsonHotelResponseStart += locationId + "&pageSize=15&checkIn="
                    + checkInDate + "&checkOut=" + checkOutDate + "&adults1=" + adults
                    + "&sortOrder=PRICE&locale=en_US&currency=USD" + "&pageNumber=";
            tempJsonResponseStart = JsonHotelResponseStart;
            JsonHotelResponseStart += pageCount;
            jsonHotelFinalLink = JsonHotelResponseStart;
            ArrayList<HotelsModel> event = HotelsQuery.fetchHotelsResults(jsonHotelFinalLink);            //also we can use  urls[0]
            Log.i(LOG_TAG,"Link: "+jsonHotelFinalLink);
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
            ArrayList<HotelsModel> event = HotelsQuery.fetchHotelsResults(jsonHotelFinalLink);
            Log.i(LOG_TAG,"Link: "+jsonHotelFinalLink);
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