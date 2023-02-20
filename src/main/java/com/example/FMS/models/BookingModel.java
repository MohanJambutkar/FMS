package com.example.FMS.models;

import javax.validation.constraints.NotNull;
import java.util.Date;


public class BookingModel {
    @NotNull(message = "BookingId is required")
    private long bookingId;
    @NotNull(message = "Booking Date is required")
    private Date bookingDate;
    @NotNull(message = "No of passengers required")
    private int noOfPassengers;

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }


}
