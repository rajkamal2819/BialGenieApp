package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;
import com.Hackathon.bialgenieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AirportPhotosAdapter extends RecyclerView.Adapter<AirportPhotosAdapter.PhotosHolder> {

    private List<String> list;
    private RecyclerView recyclerView;
    private Context context;

    public AirportPhotosAdapter(List<String> list, RecyclerView recyclerView, Context context) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;

    }

    @NonNull
    @Override
    public AirportPhotosAdapter.PhotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AirportPhotosAdapter.PhotosHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.airport_photos_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AirportPhotosAdapter.PhotosHolder holder, int position) {

        holder.setPhoto(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class PhotosHolder extends RecyclerView.ViewHolder {

        ImageView airportPhoto;

        public PhotosHolder(@NonNull View itemView) {
            super(itemView);

            airportPhoto = itemView.findViewById(R.id.airportPhotos);

        }

        void setPhoto(String link) {

            Log.d("AirportPhotosAdapter","Link:  "+link);
            Picasso.get().load(link).into(airportPhoto);

        }

    }


}