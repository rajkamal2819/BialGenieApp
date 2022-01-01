package com.Hackathon.bialgenieapp.Database;

import android.os.Parcelable;

import java.io.Serializable;


public class Route_Model implements Serializable  {

    private String routename;


    // Constructor
    public Route_Model(String route_name) {
        this.routename = route_name;

    }

    // Getter and Setter
    public String getCourse_name() {
        return routename;
    }

    public void setCourse_name(String course_name) {
        this.routename = course_name;
    }


}