package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.Hackathon.bialgenieapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.ArDepModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FlightItemAdapter extends RecyclerView.Adapter<FlightItemAdapter.FlightHolder> {

    private List<ArDepModel> list;
    private RecyclerView recyclerView;
    private Context context;
   // private int layoutId;
    static private int uniqueL;

    public FlightItemAdapter(List<ArDepModel> list, RecyclerView recyclerView, Context context, int uniqueL) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;
        this.uniqueL = uniqueL;

    }

    @NonNull
    @Override
    public FlightHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightHolder holder, int position) {

        holder.setDetails(list.get(position));

        // Log.i("Slider item: ",""+list.size());
       /* Courses currCourse = list.get(position);
        holder.setImageView(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent i = new Intent(context, CourseDetailsActivity.class);
        i.putExtra("tittle", currCourse.getTittle());
        //   i.putExtra("instructor", currCourse.getInstructorsList());
        i.putExtra("instructorImage",currCourse.getInstructorsList().get(0).getPhoto());
        i.putExtra("instructorName",currCourse.getInstructorsList().get(0).getName());
        i.putExtra("id", currCourse.getId());
        i.putExtra("url", currCourse.getUrl());
        i.putExtra("isPaid", currCourse.isPaid());
        i.putExtra("price", currCourse.getPrice());
        i.putExtra("courseThumbnail", currCourse.getCourseThumbnail());
        i.putExtra("description", currCourse.getDescription());
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        }
        });*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FlightHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView airlines;
        private TextView time1;
        private TextView time2;
        private TextView cityCode1;
        private TextView cityCode2;
        private TextView flightNumber;
        private TextView cityName1;
        private TextView cityName2;
        private ImageView imageView;

        public FlightHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            airlines = itemView.findViewById(R.id.airlinesName);
            time1 = itemView.findViewById(R.id.time1);
            time2 = itemView.findViewById(R.id.time2);
            cityName1 = itemView.findViewById(R.id.cityName1);
            cityName2 = itemView.findViewById(R.id.cityName2);
            cityCode1 = itemView.findViewById(R.id.airportCode1);
            cityCode2 = itemView.findViewById(R.id.airportCode2);
            flightNumber = itemView.findViewById(R.id.flightNumber);
            imageView = itemView.findViewById(R.id.landImage);

        }

        void setDetails
                (ArDepModel itemModel) {

            if(uniqueL == 1){         // ARRIVAL --> this is for the Arrival fragment

                // CITY 2 for the main airport BLR
                // when arrival CITY 2 = BLR else city 1 since for drawable image

                String dateArrival = itemModel.getArrivalLocalDate();
                String dateStr = dateArrival.substring(0,10);
                String timeStr = dateArrival.substring(11,16);

                //if arrival on blr then city 1 is BLR or else

                date.setText(dateStr);
                time2.setText(timeStr);

                imageView.setImageResource(R.drawable.ic_baseline_flight_land_24);

                String dateDeparture = itemModel.getDepartureLocalDate();
                String timeDep = dateDeparture.substring(11,16);

                time1.setText(timeDep);
                cityCode2.setText(itemModel.getArrivalAirport());
                cityCode1.setText(itemModel.getDepartureAirport());

                airlines.setText(itemModel.getAirlines());
                flightNumber.setText(itemModel.getCarrierCode()+itemModel.getFlightNumber());

                cityName2.setText(itemModel.getAirportArrivalInformation().getCityName());
                cityName1.setText(itemModel.getAirportDepInformation().getCityName());

             //  Log.i("FlightItemAdapter",itemModel.getDepartureLocalDate());
             //  Log.i("FlightItemAdapter",itemModel.getArrivalLocalDate());


            } else if (uniqueL == 2) {

                String dateArrival = itemModel.getArrivalLocalDate();
                String dateStr = dateArrival.substring(0,10);
                String timeStr = dateArrival.substring(11,16);

                //if arrival on blr then city 1 is BLR or else

                date.setText(dateStr);
                time2.setText(timeStr);

                imageView.setImageResource(R.drawable.ic_baseline_flight_takeoff_24);

                String dateDeparture = itemModel.getDepartureLocalDate();
                String timeDep = dateDeparture.substring(11,16);

                time1.setText(timeDep);
                cityCode2.setText(itemModel.getArrivalAirport());
                cityCode1.setText(itemModel.getDepartureAirport());

                airlines.setText(itemModel.getAirlines());
                flightNumber.setText(itemModel.getCarrierCode()+itemModel.getFlightNumber());

                cityName2.setText(itemModel.getAirportArrivalInformation().getCityName());
                cityName1.setText(itemModel.getAirportDepInformation().getCityName());
              //  Log.i("FlightItemAdapter",itemModel.getAirportArrivalInformation().getCityName());

            }

        }


    }


}