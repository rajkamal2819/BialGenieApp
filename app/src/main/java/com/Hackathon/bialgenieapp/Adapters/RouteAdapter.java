package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Hackathon.bialgenieapp.Database.Route_Model;
import com.Hackathon.bialgenieapp.Fragments.Transit.BusRoute;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.Viewholder> {

    private Context context;
    private ArrayList<Route_Model> route_modelArrayList;
   /* private final View.OnClickListener mOnClickListener = new MyOnClickListener();*/

    // Constructor
    public RouteAdapter(Context context, ArrayList<Route_Model> routeModelArrayList) {
        this.context = context;
        this.route_modelArrayList = routeModelArrayList;
    }

    @NonNull
    @Override
    public RouteAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.route_item, parent, false);
        /*view.setOnClickListener(mOnClickListener);*/
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        Route_Model model = route_modelArrayList.get(position);
        holder.routename.setText(model.getCourse_name());
       Context context1 = holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(context,holder.routename.getText().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, BusRoute.class);
                i.putExtra("route",holder.routename.getText().toString());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return route_modelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView routename;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            routename = itemView.findViewById(R.id.route_name);



        }

    }
}