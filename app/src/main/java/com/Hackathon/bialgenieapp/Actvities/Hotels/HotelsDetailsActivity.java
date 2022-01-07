package com.Hackathon.bialgenieapp.Actvities.Hotels;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.Hackathon.bialgenieapp.Models.HotelDetailsModel;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityHotelsDetailsBinding;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class HotelsDetailsActivity extends AppCompatActivity {

    ActivityHotelsDetailsBinding binding;
    ;
    private String LOG_TAG = HotelsDetailsActivity.class.getSimpleName();
    private String jsonLinkStart = "https://hotels4.p.rapidapi.com/properties/get-details?id=";
    HotelsDetailsAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Long id = getIntent().getLongExtra("id", 0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String priceInfo = getIntent().getStringExtra("priceInfo");
        Double rating = getIntent().getDoubleExtra("rating", 0);
        Double lat = getIntent().getDoubleExtra("lat", 0);
        Double lon = getIntent().getDoubleExtra("lon", 0);
        String address = getIntent().getStringExtra("address");
        String thumbnail = getIntent().getStringExtra("image");

        Picasso.get().load(thumbnail).placeholder(R.drawable.hotel_place_holder).into(binding.imageH);
        binding.addressH.setText(address);
        binding.nameH.setText(name);
        binding.priceH.setText(price + "\n(" + priceInfo + ")");
        binding.ratingBarH.setRating(rating.floatValue());

        jsonLinkStart += id;

        Log.i(LOG_TAG, "isajddfkjsdklfjksdjkf    " + jsonLinkStart);
        task = new HotelsDetailsAsyncTask();
        task.execute();

    }

    protected void updateUi(HotelDetailsModel model) {

        binding.progressBar1.setVisibility(View.GONE);
        String textHotelFeatures = "";
        if(model.getHotelFeatures()!=null) {
            for (int i = 0; i < model.getHotelFeatures().size(); i++) {
                textHotelFeatures += (i + 1) + ". " + model.getHotelFeatures().get(i) + "\n";
            }
            binding.hotelFeatures.setText(textHotelFeatures);
        } else {
            binding.hotelFeatures.setText("No Features");
        }

        String textFamilyFeatures = "";
        if(model.getFamilyFriendlyFeatures()!=null) {
            for (int i = 0; i < model.getFamilyFriendlyFeatures().size(); i++) {
                textFamilyFeatures += (i + 1) + ". " + model.getFamilyFriendlyFeatures().get(i) + "\n";
            }
            binding.hotelFamilyFeatures.setText(textFamilyFeatures);
        } else{
            binding.hotelFamilyFeatures.setText("No Family Friendly Features");
        }

        String textFreeBias = "";
        if (model.getHotelFreebies() != null) {
            for (int i = 0; i < model.getHotelFreebies().size(); i++) {
                textFreeBias += (i + 1) + ". " + model.getHotelFreebies().get(i) + "\n";
            }
            binding.hotelFreeBias.setText(textFreeBias);
        } else{
            binding.hotelFreeBias.setText("No FreeBias");
        }

    }

    private class HotelsDetailsAsyncTask extends AsyncTask<URL, Void, HotelDetailsModel> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected HotelDetailsModel doInBackground(URL... urls) {
            HotelDetailsModel event = HotelsQuery.fetchHotelsDetails(jsonLinkStart);
            Log.i(LOG_TAG, "isajddfkjsdklfjksdjkf    " + event.getHotelFeatures().size());
            Log.i(LOG_TAG, "Link: " + jsonLinkStart);
            return event;
        }

        @Override
        protected void onPostExecute(HotelDetailsModel event) {

            //  binding.loadingSpinner.setVisibility(View.GONE);
            // binding.progressBar2.setVisibility(View.GONE);

            if (event == null) {
                //  binding.emptyTextView.setText("No Hotels Found");
                return;
            }

            //  hotelsModelsList.addAll(event);
            updateUi(event);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        task.cancel(true);
    }
    
}