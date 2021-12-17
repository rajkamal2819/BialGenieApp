package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.FlightSearchActivity;
import com.Hackathon.bialgenieapp.FlightsDetailsActivity;
import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.R;

import java.util.List;

public class FlightSearchAdapter extends RecyclerView.Adapter<FlightSearchAdapter.FlightHolder2> {

    private List<FSModel> list;
    private RecyclerView recyclerView;
    private Context context;

    public FlightSearchAdapter(List<FSModel> list, RecyclerView recyclerView, Context context) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;

    }

    @NonNull
    @Override
    public FlightSearchAdapter.FlightHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightSearchAdapter.FlightHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_item_2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightSearchAdapter.FlightHolder2 holder, int position) {
        Log.i("FlightSearchAdapter",list.get(position).toString());
         holder.setDetails(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FlightHolder2 extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView time1;
        private TextView time2;
        private TextView cityCode1;
        private TextView cityCode2;
        private TextView flightNumber;

        public FlightHolder2(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateSS);
            time1 = itemView.findViewById(R.id.time1SS);
            time2 = itemView.findViewById(R.id.time2SS);
            cityCode1 = itemView.findViewById(R.id.airportCode1SS);
            cityCode2 = itemView.findViewById(R.id.airportCode2SS);
            flightNumber = itemView.findViewById(R.id.flightNumberSS);

        }

        void setDetails(FSModel itemModel) {

           if(itemModel !=null){

               FSModel.FlightSpots spots1 = itemModel.getFlightSpotsList().get(0);
               FSModel.FlightSpots spots2 = itemModel.getFlightSpotsList().get(itemModel.getFlightSpotsList().size()-1);

               String dateArrival = spots1.getDepartureTime();
               String dateAr = dateArrival.substring(0,10);
               String timeAr = dateArrival.substring(11,16);

               String dateDeparture = spots2.getArrivalTime();
             //  String dateDep = dateDeparture.substring(0,10);
               String timeDep = dateDeparture.substring(11,16);

               date.setText(dateAr);
               time1.setText(timeAr);
               time2.setText(timeDep);

               cityCode1.setText(spots1.getDepartureAirport());
               cityCode2.setText(spots2.getArrivalAirport());

               flightNumber.setText(spots1.getAirlines()+spots1.getAirlineNumber());

           }

        }


    }
}