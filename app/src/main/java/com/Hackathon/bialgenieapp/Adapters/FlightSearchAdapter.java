package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.FlightSearchDetails;
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

         //"https://api.flightstats.com/flex/flightstatus/rest/v2/json/flight/status/JL/754
        // /dep/2021/12/18?appId=3d44123a&appKey=ce3c12a840540d7528f086a02ccd3f2a&utc=false"

          holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(context,FlightSearchDetails.class);
                  i.putExtra("curModel",list.get(holder.getAdapterPosition()));
                  i.putExtra("identifyCode",1);
                  i.putExtra("curModelList",list.get(holder.getAdapterPosition()).getFlightSpotsList());
                  context.startActivity(i);
              }
          });

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

               String dateDep = spots1.getDepartureTime();
               String dateDp = dateDep.substring(0,10);
               String timeDp = dateDep.substring(11,16);

               String dateArrival = spots2.getArrivalTime();
             //  String dateDep = dateDeparture.substring(0,10);
               String timeAr = dateArrival.substring(11,16);

               date.setText(dateDp);
               time1.setText(timeDp);
               time2.setText(timeAr);

               cityCode1.setText(spots1.getDepartureAirport());
               cityCode2.setText(spots2.getArrivalAirport());

               flightNumber.setText(spots1.getAirlines()+spots1.getAirlineNumber());

           }

        }


    }
}