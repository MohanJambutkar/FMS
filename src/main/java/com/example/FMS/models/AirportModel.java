package com.example.FMS.models;

import java.util.Date;

public class AirportModel {
    private long airportCode;
    private String airportLocations;
    private String airportName;


    public Long getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(Long airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportLocations() {
        return airportLocations;
    }

    public void setAirportLocations(String airportLocations) {
        this.airportLocations = airportLocations;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }


}
