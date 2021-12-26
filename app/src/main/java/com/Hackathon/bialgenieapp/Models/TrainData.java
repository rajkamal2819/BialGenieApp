package com.Hackathon.bialgenieapp.Models;

import java.util.HashMap;
import java.util.List;

public class TrainData {
    String trainName,arrivalStn,destinationStr;
    HashMap<String,String> days;
    List<String> classes;

    public TrainData(String trainName, String arrivalStn, String destinationStr, HashMap<String,String> days, List<String> classes) {
        this.trainName = trainName;
        this.arrivalStn = arrivalStn;
        this.destinationStr = destinationStr;
        this.days = days;
        this.classes = classes;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getArrivalStn() {
        return arrivalStn;
    }

    public String getDestinationStr() {
        return destinationStr;
    }

    public HashMap<String, String> getDays() {
        return days;
    }

    public List<String> getClasses() {
        return classes;
    }
}
