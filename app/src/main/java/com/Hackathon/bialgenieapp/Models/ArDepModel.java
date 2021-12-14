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
    private Integer flightDurationMinutes;
    private Integer departureTerminal;
    private Integer departureGate;

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

    public Integer getFlightDurationMinutes() {
        return flightDurationMinutes;
    }

    public void setFlightDurationMinutes(Integer flightDurationMinutes) {
        this.flightDurationMinutes = flightDurationMinutes;
    }

    public Integer getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(Integer departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public Integer getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(Integer departureGate) {
        this.departureGate = departureGate;
    }
}
