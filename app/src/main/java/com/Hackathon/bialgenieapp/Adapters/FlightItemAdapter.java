package com.Hackathon.bialgenieapp.Adapters;

import android.content.Context;
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
    private int layoutId;
    static private int uniqueL;

    public FlightItemAdapter(List<ArDepModel> list, RecyclerView recyclerView, Context context, int layoutId, int uniqueL) {
        this.list = list;
        this.recyclerView = recyclerView;
        this.context = context;
        this.layoutId = layoutId;
        this.uniqueL = uniqueL;

    }

    @NonNull
    @Override
    public FlightHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightHolder holder, int position) {

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
        private TextView departingTime;
        private TextView arrivingTime;
        private TextView departingCityCode;
        private TextView arrivingCityCode;
        private TextView flightNumber;
        private TextView departingCityName;
        private TextView arrivingCityName;
        private ImageView imageView;

        public FlightHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            airlines = itemView.findViewById(R.id.airlinesName);
            departingTime = itemView.findViewById(R.id.departingTime);
            arrivingTime = itemView.findViewById(R.id.arrivingTime);
            departingCityName = itemView.findViewById(R.id.departingCityName);
            arrivingCityName = itemView.findViewById(R.id.arrivingCityName);
            departingCityCode = itemView.findViewById(R.id.departingAirportCode);
            arrivingCityCode = itemView.findViewById(R.id.arrivingAirportCode);
            flightNumber = itemView.findViewById(R.id.flightNumber);
            imageView = itemView.findViewById(R.id.landImage);

        }

        void setImageView(ArDepModel itemModel) {

            if (uniqueL == 1) {

               // date.setText(itemModel.get);

            } /*else if (uniqueL == 2) {
                categoryCourseName.setText(sliderItem.getTittle());
                if (sliderItem.getCourseThumbnail() != null) {
                    try {
                        Glide.with(categoryCourseImage.getContext())
                                .load(new URL(sliderItem.getCourseThumbnail()))
                                .into(categoryCourseImage);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Glide.with(categoryCourseImage.getContext()).load(R.drawable.courses_icon).into(categoryCourseImage);
                }
            }*/

        }


    }


}