package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.ParkingChargesData;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;
import java.util.List;

public class ParkingListChargesAdapter extends RecyclerView.Adapter<ParkingListChargesAdapter.ParkingChargesViewHolder> {
    List<ParkingChargesData> dataClass;
    Context context;

    public ParkingListChargesAdapter(List<ParkingChargesData> dataclass, Context context){
        this.dataClass=dataclass;
        this.context=context;
    }

    @Override
    public ParkingChargesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parking_charges_items,parent,false);

       return new ParkingChargesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingListChargesAdapter.ParkingChargesViewHolder holder, int position) {
        ParkingChargesData pd=dataClass.get(position);

        holder.title.setText(pd.getMainTitle());
        holder.lTitle.setText(pd.getlTitle());
        holder.rTitle.setText(pd.getrTitle());
        holder.duration1.setText(pd.getT1());
        holder.duration2.setText(pd.getT2());
        holder.duration3.setText(pd.getT3());
        holder.duration4.setText(pd.getT4());
        holder.duration5.setText(pd.getT5());
        holder.fare1.setText(pd.getF1());
        holder.fare2.setText(pd.getF2());
        holder.fare3.setText(pd.getF3());
        holder.fare4.setText(pd.getF4());
        holder.fare5.setText(pd.getF5());
    }

    @Override
    public int getItemCount() {
        return dataClass.size();
    }

    public class ParkingChargesViewHolder extends RecyclerView.ViewHolder{
        TextView title,lTitle,rTitle,duration1,duration2,duration3,duration4,duration5,fare1,fare2,fare3,fare4,fare5;

        public ParkingChargesViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.head_title_text);
            lTitle=itemView.findViewById(R.id.duration_text);
            rTitle=itemView.findViewById(R.id.fare_text);
            duration1=itemView.findViewById(R.id.duration1_text);
            duration2=itemView.findViewById(R.id.duration2_text);
            duration3=itemView.findViewById(R.id.duration3_text);
            duration4=itemView.findViewById(R.id.duration4_text);
            duration5=itemView.findViewById(R.id.duration5_text);
            fare1=itemView.findViewById(R.id.fare1_text);
            fare2=itemView.findViewById(R.id.fare2_text);
            fare3=itemView.findViewById(R.id.fare3_text);
            fare4=itemView.findViewById(R.id.fare4_text);
            fare5=itemView.findViewById(R.id.fare5_text);
        }
    }
}
