package com.Hackathon.bialgenieapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class FSModel implements Parcelable {                    //  flight search model

    private String totalJourneyDuration;

    public FSModel(Parcel in) {
        totalJourneyDuration = in.readString();
    }

    public static final Creator<FSModel> CREATOR = new Creator<FSModel>() {
        @Override
        public FSModel createFromParcel(Parcel in) {
            return new FSModel(in);
        }

        @Override
        public FSModel[] newArray(int size) {
            return new FSModel[size];
        }
    };

    public FSModel() {

    }

    public String getTotalJourneyDuration() {
        return totalJourneyDuration;
    }

    public void setTotalJourneyDuration(String totalJourneyDuration) {
        this.totalJourneyDuration = totalJourneyDuration;
    }

    public ArrayList<FlightSpots> getFlightSpotsList() {
        return flightSpotsList;
    }

    public void setFlightSpotsList(ArrayList<FlightSpots> flightSpotsList) {
        this.flightSpotsList = flightSpotsList;
    }

    private ArrayList<FlightSpots> flightSpotsList;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(totalJourneyDuration);
    }

    public static class FlightSpots implements Parcelable{              // flight spots
        private String departureAirport;
        private String departureTime;
        private String arrivalAirport;
        private String arrivalTime;
        private String departureTerminal;

        public FlightSpots(Parcel in) {
            departureAirport = in.readString();
            departureTime = in.readString();
            arrivalAirport = in.readString();
            arrivalTime = in.readString();
            departureTerminal = in.readString();
            arrivalTerminal = in.readString();
            airlines = in.readString();
            airlineNumber = in.readString();
        }

        public static final Creator<FlightSpots> CREATOR = new Creator<FlightSpots>() {
            @Override
            public FlightSpots createFromParcel(Parcel in) {
                return new FlightSpots(in);
            }

            @Override
            public FlightSpots[] newArray(int size) {
                return new FlightSpots[size];
            }
        };

        public FlightSpots() {

        }

        public String getDepartureAirport() {
            return departureAirport;
        }

        public void setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        public String getArrivalAirport() {
            return arrivalAirport;
        }

        public void setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
        }

        public String getDepartureTerminal() {
            return departureTerminal;
        }

        public void setDepartureTerminal(String departureTerminal) {
            this.departureTerminal = departureTerminal;
        }

        public String getArrivalTerminal() {
            return arrivalTerminal;
        }

        public void setArrivalTerminal(String arrivalTerminal) {
            this.arrivalTerminal = arrivalTerminal;
        }

        public String getAirlines() {
            return airlines;
        }

        public void setAirlines(String airlines) {
            this.airlines = airlines;
        }

        public String getAirlineNumber() {
            return airlineNumber;
        }

        public void setAirlineNumber(String airlineNumber) {
            this.airlineNumber = airlineNumber;
        }

        private String arrivalTerminal;
        private String airlines;
        private String airlineNumber;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(departureAirport);
            dest.writeString(departureTime);
            dest.writeString(arrivalAirport);
            dest.writeString(arrivalTime);
            dest.writeString(departureTerminal);
            dest.writeString(arrivalTerminal);
            dest.writeString(airlines);
            dest.writeString(airlineNumber);
        }
    }

}
