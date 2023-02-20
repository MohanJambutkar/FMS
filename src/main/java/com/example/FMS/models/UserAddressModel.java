package com.example.FMS.models;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserAddressModel {
    @NotNull(message = "UserAddressId Id is required")
    private long addressId;
    @NotNull(message = "User Id is required")
    private long userId;

    private String line;

    private String landmark;
    @NotNull(message = "PinCode is required")
    private int pincode;
    @NotNull(message = "State is required")
    private String state;
    @NotNull(message = "City is required")
    private String city;


    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
