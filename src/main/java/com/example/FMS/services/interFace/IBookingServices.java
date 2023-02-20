package com.example.FMS.services.interFace;

import com.example.FMS.dto.booking.Bookings;
import com.example.FMS.models.BookingModel;

import java.util.List;
import java.util.Optional;

public interface IBookingServices {
    long createBooking(BookingModel bookingModel);
    long updateBooing(BookingModel bookingModel, long bookingId);
    long deleteBooking(BookingModel bookingModel, long bookingId);
    List<Bookings> viewAllBooking();
    Optional<Bookings> ViewBookingById(long bookingId);

}
