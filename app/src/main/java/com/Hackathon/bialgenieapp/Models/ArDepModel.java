package com.Hackathon.bialgenieapp.Models;

public class ArDepModel {

    private Long flightId;
    private String carrierCode;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private String departureLocalDate;
    private String arrivalLocalDate;
    private String flightType;
    private String serviceClasses;
    private Integer departureGateDelayMinutes;
    private Integer arrivalGateDelayMinutes;
    private String departureTerminal;
    private String departureGate;
    private String arrivalGate;
    private String arrivalTerminal;
    private String airlines;
    private airportInformation airportDepInformation;
    private airportInformation airportArrivalInformation;

    public String getArrivalGate() {
        return arrivalGate;
    }

    public void setArrivalGate(String arrivalGate) {
        this.arrivalGate = arrivalGate;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    private Integer flightDurationMinutes;

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public airportInformation getAirportDepInformation() {
        return airportDepInformation;
    }

    public void setAirportDepInformation(airportInformation airportDepInformation) {
        this.airportDepInformation = airportDepInformation;
    }

    public airportInformation getAirportArrivalInformation() {
        return airportArrivalInformation;
    }

    public void setAirportArrivalInformation(airportInformation airportArrivalInformation) {
        this.airportArrivalInformation = airportArrivalInformation;
    }

    public static class airportInformation {

        String cityCode;
        String cityName;
        String airportName;
        String countryName;
        String localTime;
        String weatherUrl;
        Double longitude;
        Double latitude;
        Integer elevationFeet;

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getLocalTime() {
            return localTime;
        }

        public void setLocalTime(String localTime) {
            this.localTime = localTime;
        }

        public String getWeatherUrl() {
            return weatherUrl;
        }

        public void setWeatherUrl(String weatherUrl) {
            this.weatherUrl = weatherUrl;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Integer getElevationFeet() {
            return elevationFeet;
        }

        public void setElevationFeet(Integer elevationFeet) {
            this.elevationFeet = elevationFeet;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getAirportName() {
            return airportName;
        }

        public void setAirportName(String airportName) {
            this.airportName = airportName;
        }
    }

    public Integer getFlightDurationMinutes() {
        return flightDurationMinutes;
    }

    public void setFlightDurationMinutes(Integer flightDurationMinutes) {
        this.flightDurationMinutes = flightDurationMinutes;
    }
    
    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureLocalDate() {
        return departureLocalDate;
    }

    public void setDepartureLocalDate(String departureLocalDate) {
        this.departureLocalDate = departureLocalDate;
    }

    public String getArrivalLocalDate() {
        return arrivalLocalDate;
    }

    public void setArrivalLocalDate(String arrivalLocalDate) {
        this.arrivalLocalDate = arrivalLocalDate;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getServiceClasses() {
        return serviceClasses;
    }

    public void setServiceClasses(String serviceClasses) {
        this.serviceClasses = serviceClasses;
    }

    public Integer getDepartureGateDelayMinutes() {
        return departureGateDelayMinutes;
    }

    public void setDepartureGateDelayMinutes(Integer departureGateDelayMinutes) {
        this.departureGateDelayMinutes = departureGateDelayMinutes;
    }

    public Integer getArrivalGateDelayMinutes() {
        return arrivalGateDelayMinutes;
    }

    public void setArrivalGateDelayMinutes(Integer arrivalGateDelayMinutes) {
        this.arrivalGateDelayMinutes = arrivalGateDelayMinutes;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
    }
}
