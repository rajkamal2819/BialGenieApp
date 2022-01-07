package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Fragments.Transit.CalculateTime;
import com.Hackathon.bialgenieapp.Models.ParkingDetails;
import com.Hackathon.bialgenieapp.R;

import java.util.List;

public class TrackChargesListAdapter extends RecyclerView.Adapter<TrackChargesListAdapter.TrackChargesViewHolder> {

    List<ParkingDetails> parkingDetailsList;
    Context context;

    public TrackChargesListAdapter(Context context,List<ParkingDetails> parkingDetailsList){
        this.parkingDetailsList=parkingDetailsList;
        this.context=context;
    }
    @NonNull
    @Override
    public TrackChargesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parking_main_list,parent,false);
        return new TrackChargesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackChargesViewHolder holder, int position) {
            ParkingDetails parkingDetails= parkingDetailsList.get(position);



            holder.carType.setText(parkingDetails.getCarType());
            holder.date.setText(parkingDetails.getDate());
            holder.time.setText(parkingDetails.getTime());
            holder.elapsedTime.setText(parkingDetails.getElapsedTime());
    }

    @Override
    public int getItemCount() {
        return parkingDetailsList.size();
    }

    public static class TrackChargesViewHolder extends RecyclerView.ViewHolder{
        TextView date,time,elapsedTime,carType;
        public TrackChargesViewHolder(@NonNull View itemView) {
            super(itemView);
            carType=itemView.findViewById(R.id.car_type_text_view);
            time=itemView.findViewById(R.id.time_text_view);
            date=itemView.findViewById(R.id.date_text_view);
            elapsedTime=itemView.findViewById(R.id.time_elapsed);
        }
    }
}
