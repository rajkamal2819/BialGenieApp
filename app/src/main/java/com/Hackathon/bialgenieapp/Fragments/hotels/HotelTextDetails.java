package com.Hackathon.bialgenieapp.Fragments.hotels;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.Hackathon.bialgenieapp.Models.HotelDetailsModel;
import com.Hackathon.bialgenieapp.Models.HotelsModel;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentHotelTextDetailsBinding;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class HotelTextDetails extends Fragment {

    public HotelTextDetails() {
        // Required empty public constructor
    }

    FragmentHotelTextDetailsBinding binding;
    private String LOG_TAG = HotelTextDetails.class.getSimpleName();
    private String jsonLinkStart = "https://hotels4.p.rapidapi.com/properties/get-details?id=";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHotelTextDetailsBinding.inflate(getLayoutInflater());

        Long id = getActivity().getIntent().getLongExtra("id",0);
        String name = getActivity().getIntent().getStringExtra("name");
        String price = getActivity().getIntent().getStringExtra("price");
        String priceInfo = getActivity().getIntent().getStringExtra("priceInfo");
        Double rating = getActivity().getIntent().getDoubleExtra("rating",0);
        Double lat = getActivity().getIntent().getDoubleExtra("lat",0);
        Double lon = getActivity().getIntent().getDoubleExtra("lon",0);
        String address = getActivity().getIntent().getStringExtra("address");
        String thumbnail = getActivity().getIntent().getStringExtra("image");

        Picasso.get().load(thumbnail).placeholder(R.drawable.hotel_place_holder).into(binding.imageH);
        binding.addressH.setText(address);
        binding.nameH.setText(name);
        binding.priceH.setText(price+"\n("+priceInfo+")");
        binding.ratingBarH.setRating(rating.floatValue());

        jsonLinkStart += id;

        Log.i(LOG_TAG,"isajddfkjsdklfjksdjkf    "+jsonLinkStart);
        HotelsDetailsAsyncTask task = new HotelsDetailsAsyncTask();
        task.execute();


        return binding.getRoot();
    }

    protected void updateUi(HotelDetailsModel model){

        String textHotelFeatures = "";
        for (int i = 0;i<model.getHotelFeatures().size();i++){
            textHotelFeatures += i+". "+model.getHotelFeatures().get(i) + "\n";
        }
        binding.hotelFeatures.setText(textHotelFeatures);

        String textFamilyFeatures = "";
        for (int i = 0;i<model.getFamilyFriendlyFeatures().size();i++){
            textFamilyFeatures += i+". "+model.getHotelFeatures().get(i) + "\n";
        }
        binding.hotelFamilyFeatures.setText(textFamilyFeatures);

        String textFreeBias = "";
        for (int i = 0;i<model.getHotelFreebies().size();i++){
            textFreeBias += i+". "+model.getHotelFeatures().get(i) + "\n";
        }
        binding.hotelFreeBias.setText(textFreeBias);

    }

    private class HotelsDetailsAsyncTask extends AsyncTask<URL, Void,HotelDetailsModel> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected HotelDetailsModel doInBackground(URL... urls) {
            HotelDetailsModel event = HotelsQuery.fetchHotelsDetails(jsonLinkStart);
            Log.i(LOG_TAG,"isajddfkjsdklfjksdjkf    "+event.getHotelFeatures().size());
            Log.i(LOG_TAG,"Link: "+jsonLinkStart);
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

}