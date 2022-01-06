package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;
import com.Hackathon.bialgenieapp.R;

import java.util.List;

public class RestaurantShoppingAdapter extends RecyclerView.Adapter<RestaurantShoppingAdapter.RestaurantHolder> {

    private List<RestaurantShoppingModel> list;
    private RecyclerView recyclerView;
    private Context context;

    public RestaurantShoppingAdapter(List<RestaurantShoppingModel> list, RecyclerView recyclerView, Context context) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;

    }

    @NonNull
    @Override
    public RestaurantShoppingAdapter.RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RestaurantShoppingAdapter.RestaurantHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantShoppingAdapter.RestaurantHolder holder, int position) {

        holder.setRestaurantDetails(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class RestaurantHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView description;
        private TextView timings;
        private TextView location;
        private TextView contact;
        private TextView email;

        public RestaurantHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameRes);
            description = itemView.findViewById(R.id.descriptionRes);
            timings = itemView.findViewById(R.id.timingsRes);
            location = itemView.findViewById(R.id.locationRes);
            contact = itemView.findViewById(R.id.contactRes);
            email = itemView.findViewById(R.id.emailRes);


        }

        void setRestaurantDetails(RestaurantShoppingModel itemModel) {

            name.setText(itemModel.getName());
            description.setText(itemModel.getDescription());
            timings.setText(itemModel.getTimings());
            location.setText(itemModel.getLocation());
            contact.setText(itemModel.getContact());
            email.setText(itemModel.getEmail());


        }


    }


}