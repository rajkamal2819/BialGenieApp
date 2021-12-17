package com.Hackathon.bialgenieapp.Models;

import java.util.ArrayList;

public class FSModel {                    //  flight search model

    private String totalJourneyDuration;

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

    public class FlightSpots{              // flight spots
        private String departureAirport;
        private String departureTime;
        private String arrivalAirport;
        private String arrivalTime;
        private String departureTerminal;

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
    }

}
