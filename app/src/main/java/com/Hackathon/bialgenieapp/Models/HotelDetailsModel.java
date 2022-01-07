package com.Hackathon.bialgenieapp.Models;

import java.util.ArrayList;

public class HotelDetailsModel {

    private ArrayList<String> hotelFeatures;
    private ArrayList<String> familyFriendlyFeatures;
    private ArrayList<String> hotelFreebies;

    public ArrayList<String> getHotelFeatures() {
        return hotelFeatures;
    }

    public void setHotelFeatures(ArrayList<String> hotelFeatures) {
        this.hotelFeatures = hotelFeatures;
    }

    public ArrayList<String> getFamilyFriendlyFeatures() {
        return familyFriendlyFeatures;
    }

    public void setFamilyFriendlyFeatures(ArrayList<String> familyFriendlyFeatures) {
        this.familyFriendlyFeatures = familyFriendlyFeatures;
    }

    public ArrayList<String> getHotelFreebies() {
        return hotelFreebies;
    }

    public void setHotelFreebies(ArrayList<String> hotelFreebies) {
        this.hotelFreebies = hotelFreebies;
    }
}
