package com.example.FMS.models;

import javax.validation.constraints.NotNull;

public class FlightModel {
    @NotNull(message = "Flight No is required")
    private long flightNo;
    @NotNull(message = "Flight Name is required")
    private String carrierName;
    @NotNull(message = "FlightType is required")
    private String fightType;
    @NotNull(message = "Seat Available is required")
    private  int seatCapacity;

    public long getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(long flightNo) {
        this.flightNo = flightNo;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getFightType() {
        return fightType;
    }

    public void setFightType(String fightType) {
        this.fightType = fightType;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
