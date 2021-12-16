package com.Hackathon.bialgenieapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ArDepModel implements Parcelable {

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

    public ArDepModel() {

    }

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

    public static class airportInformation implements Parcelable{

        String cityCode;
        String cityName;
        String airportName;
        String countryName;
        String localTime;
        String weatherUrl;
        Double longitude;
        Double latitude;
        Integer elevationFeet;

        public airportInformation(Parcel in) {
            cityCode = in.readString();
            cityName = in.readString();
            airportName = in.readString();
            countryName = in.readString();
            localTime = in.readString();
            weatherUrl = in.readString();
            if (in.readByte() == 0) {
                longitude = null;
            } else {
                longitude = in.readDouble();
            }
            if (in.readByte() == 0) {
                latitude = null;
            } else {
                latitude = in.readDouble();
            }
            if (in.readByte() == 0) {
                elevationFeet = null;
            } else {
                elevationFeet = in.readInt();
            }
        }

        public static final Creator<airportInformation> CREATOR = new Creator<airportInformation>() {
            @Override
            public airportInformation createFromParcel(Parcel in) {
                return new airportInformation(in);
            }

            @Override
            public airportInformation[] newArray(int size) {
                return new airportInformation[size];
            }
        };

        public airportInformation() {

        }

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(cityCode);
            dest.writeString(cityName);
            dest.writeString(airportName);
            dest.writeString(countryName);
            dest.writeString(localTime);
            dest.writeString(weatherUrl);
            if (longitude == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeDouble(longitude);
            }
            if (latitude == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeDouble(latitude);
            }
            if (elevationFeet == null) {
                dest.writeByte((byte) 0);
            } else {
                dest.writeByte((byte) 1);
                dest.writeInt(elevationFeet);
            }
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

     /** Parcel Implementation **/

     public ArDepModel(Parcel in) {
        if (in.readByte() == 0) {
            flightId = null;
        } else {
            flightId = in.readLong();
        }
        carrierCode = in.readString();
        flightNumber = in.readString();
        departureAirport = in.readString();
        arrivalAirport = in.readString();
        departureLocalDate = in.readString();
        arrivalLocalDate = in.readString();
        flightType = in.readString();
        serviceClasses = in.readString();
        if (in.readByte() == 0) {
            departureGateDelayMinutes = null;
        } else {
            departureGateDelayMinutes = in.readInt();
        }
        if (in.readByte() == 0) {
            arrivalGateDelayMinutes = null;
        } else {
            arrivalGateDelayMinutes = in.readInt();
        }
        departureTerminal = in.readString();
        departureGate = in.readString();
        arrivalGate = in.readString();
        arrivalTerminal = in.readString();
        airlines = in.readString();
        if (in.readByte() == 0) {
            flightDurationMinutes = null;
        } else {
            flightDurationMinutes = in.readInt();
        }
    }

    public static final Creator<ArDepModel> CREATOR = new Creator<ArDepModel>() {
        @Override
        public ArDepModel createFromParcel(Parcel in) {
            return new ArDepModel(in);
        }

        @Override
        public ArDepModel[] newArray(int size) {
            return new ArDepModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (flightId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(flightId);
        }
        dest.writeString(carrierCode);
        dest.writeString(flightNumber);
        dest.writeString(departureAirport);
        dest.writeString(arrivalAirport);
        dest.writeString(departureLocalDate);
        dest.writeString(arrivalLocalDate);
        dest.writeString(flightType);
        dest.writeString(serviceClasses);
        if (departureGateDelayMinutes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(departureGateDelayMinutes);
        }
        if (arrivalGateDelayMinutes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(arrivalGateDelayMinutes);
        }
        dest.writeString(departureTerminal);
        dest.writeString(departureGate);
        dest.writeString(arrivalGate);
        dest.writeString(arrivalTerminal);
        dest.writeString(airlines);
        if (flightDurationMinutes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(flightDurationMinutes);
        }
    }

}
