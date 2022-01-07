package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Actvities.Hotels.HotelsDetailsActivity;
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
        HotelsModel model = list.get(pos);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, HotelsDetailsActivity.class);
                i.putExtra("name",model.getName());
                i.putExtra("lat",model.getLatitude());
                i.putExtra("lon",model.getLongitude());
                i.putExtra("rating",model.getStarRating());
                i.putExtra("price",model.getCurrentPrice());
                i.putExtra("priceInfo",model.getPriceInfo());
                i.putExtra("id",model.getId());
                i.putExtra("address",model.getAddress());
                i.putExtra("image",model.getThumbnail());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

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