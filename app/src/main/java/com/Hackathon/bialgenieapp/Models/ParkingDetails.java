package com.Hackathon.bialgenieapp.Models;

public class ParkingDetails {
    String time,date,elapsedTime,carType;

    public ParkingDetails(String time, String date, String elapsedTime, String carType) {
        this.time = time;
        this.date = date;
        this.elapsedTime = elapsedTime;
        this.carType = carType;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public String getCarType() {
        return carType;
    }
}
