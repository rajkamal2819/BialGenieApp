package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.TrainData;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;
import java.util.List;

public class TrainListAdapter extends RecyclerView.Adapter<TrainListAdapter.TrainViewHolder> {

    List<TrainData> trainList;
    Context context;
    String trainName;

    public TrainListAdapter(List<TrainData> trainList,Context context,String trainName){
        this.trainList=trainList;
        this.context=context;
        this.trainName=trainName;
    }
    @NonNull

    @Override
    public TrainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.train_list,parent,false);

        return new TrainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainListAdapter.TrainViewHolder holder, int position) {
        TrainData trainData= trainList.get(position);

        holder.trainName.setText(trainData.getTrainName());


        holder.arrivalStn.setText(trainData.getDestinationStr());
        holder.destStn.setText(trainData.getArrivalStn());




        if (trainData.getDays().get("Mon").equals("1")){
            holder.monday.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }


        if(trainData.getDays().get("Tue").equals("1")){
            holder.tue.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }

        if (trainData.getDays().get("Wed").equals("1")){
            holder.wed.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }


        if (trainData.getDays().get("Thu").equals("1")){
            holder.thu.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }


        if (trainData.getDays().get("Fri").equals("1")){
            holder.fri.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }


        if (trainData.getDays().get("Sat").equals("1")){
            holder.sat.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }


        if (trainData.getDays().get("Sun").equals("1")){
            holder.sun.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(R.color.green)));
        }


        StringBuilder str=new StringBuilder();

        for (int i = 0; i <trainData.getClasses().size();i++) {
            str.append(trainData.getClasses().get(i)+" ");
        }

        holder.coaches.setText(str.toString());

    }

    @Override
    public int getItemCount() {
        return trainList.size();
    }

    public static class TrainViewHolder extends RecyclerView.ViewHolder{
        TextView trainName,monday,tue,wed,thu,fri,sat,sun,arrivalStn,destStn,coaches;

        public TrainViewHolder(@NonNull View itemView) {
            super(itemView);

            trainName=itemView.findViewById(R.id.train_name_item_text);
            arrivalStn=itemView.findViewById(R.id.station_name_arrival);
            destStn=itemView.findViewById(R.id.station_name_departure);
            monday=itemView.findViewById(R.id.monday);
            tue=itemView.findViewById(R.id.tuesday);
            wed=itemView.findViewById(R.id.wednesday);
            thu=itemView.findViewById(R.id.thursday);
            fri=itemView.findViewById(R.id.friday);
            sat=itemView.findViewById(R.id.saturday);
            sun=itemView.findViewById(R.id.sunday);
            coaches=itemView.findViewById(R.id.sleeping_coaches_text);
        }
    }
}
