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

import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.FlightDetailsActivity2;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.R;

import java.util.List;

public class FlightStopsAdapter extends RecyclerView.Adapter<FlightStopsAdapter.FlightHolder3> {

    private List<FSModel.FlightSpots> list;
    private RecyclerView recyclerView;
    private Context context;

    public FlightStopsAdapter(List<FSModel.FlightSpots> list, RecyclerView recyclerView, Context context) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;

    }

    @NonNull
    @Override
    public FlightStopsAdapter.FlightHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightStopsAdapter.FlightHolder3(LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_stops_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightStopsAdapter.FlightHolder3 holder, int position) {

        FSModel.FlightSpots cur = list.get(holder.getAdapterPosition());
        holder.setDetails(cur);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, FlightDetailsActivity2.class);
                String linkStart = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/flight/status/";
                linkStart += cur.getAirlines() + "/" + cur.getAirlineNumber() + "/" + "dep/";

                String date = cur.getDepartureTime();
                String year = date.substring(0, 4);
                String month = date.substring(5, 7);
                String day = date.substring(8, 10);
                String dt = year + "/" + month + "/" + day;

                linkStart += dt + "?appId=3d44123a&appKey=ce3c12a840540d7528f086a02ccd3f2a&utc=false";
                i.putExtra("linkFlight", linkStart);
                Log.i("FlightStopAdapter",linkStart);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FlightHolder3 extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView time1;
        private TextView time2;
        private TextView cityCode1;
        private TextView cityCode2;
        private TextView flightNumber;

        public FlightHolder3(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateDD);
            time1 = itemView.findViewById(R.id.time1DD);
            time2 = itemView.findViewById(R.id.time2DD);
            cityCode1 = itemView.findViewById(R.id.airportCode1DD);
            cityCode2 = itemView.findViewById(R.id.airportCode2DD);
            flightNumber = itemView.findViewById(R.id.flightNumberDD);

        }

        void setDetails(FSModel.FlightSpots itemModel) {

            if (itemModel != null) {

                cityCode1.setText(itemModel.getDepartureAirport());
                cityCode2.setText(itemModel.getArrivalAirport());

                flightNumber.setText(itemModel.getAirlines() + itemModel.getAirlineNumber());

                String dateDep = itemModel.getDepartureTime();
                String dateDp = dateDep.substring(0, 10);
                String timeDp = dateDep.substring(11, 16);

                String dateArrival = itemModel.getArrivalTime();
                //  String dateDep = dateDeparture.substring(0,10);
                String timeAr = dateArrival.substring(11, 16);

                time1.setText(timeDp);
                time2.setText(timeAr);
                date.setText(dateDp);

            }

        }


    }
}