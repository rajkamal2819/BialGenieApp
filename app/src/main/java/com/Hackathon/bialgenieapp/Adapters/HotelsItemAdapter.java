package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.HotelsModel;
import com.Hackathon.bialgenieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HotelsItemAdapter extends RecyclerView.Adapter<HotelsItemAdapter.HotelsHolder> {

    private List<HotelsModel> list;
    private RecyclerView recyclerView;
    private Context context;

    public HotelsItemAdapter(List<HotelsModel> list, RecyclerView recyclerView, Context context) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;

    }

    @NonNull
    @Override
    public HotelsItemAdapter.HotelsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotelsItemAdapter.HotelsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotelsItemAdapter.HotelsHolder holder, int position) {

        int pos = holder.getAdapterPosition();
        holder.setHotelDetails(list.get(pos));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class HotelsHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;
        private TextView address;
        private RatingBar ratingBar;
        private TextView price;
        private TextView email;

        public HotelsHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameHt);
            image = itemView.findViewById(R.id.imageHt);
            address = itemView.findViewById(R.id.addressHt);
            ratingBar = itemView.findViewById(R.id.ratingBarHt);
            price = itemView.findViewById(R.id.priceHt);

        }

        void setHotelDetails(HotelsModel itemModel) {

            name.setText(itemModel.getName());
            address.setText(itemModel.getAddress());
            ratingBar.setRating(itemModel.getStarRating().floatValue());
            price.setText(itemModel.getCurrentPrice()+"\n("+itemModel.getPriceInfo()+")");
            Picasso.get().load(itemModel.getThumbnail()).placeholder(R.drawable.hotel_place_holder).into(image);

        }


    }


}