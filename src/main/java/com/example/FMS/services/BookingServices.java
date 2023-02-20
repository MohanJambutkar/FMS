package com.example.FMS.services;

import com.example.FMS.dto.booking.Bookings;
import com.example.FMS.exceptions.CustomExceptions;
import com.example.FMS.models.BookingModel;
import com.example.FMS.repository.BookingRepository;
import com.example.FMS.services.interFace.IBookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServices implements IBookingServices {
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public long createBooking(BookingModel bookingModel) {
       try{
           Bookings bookings = new Bookings();
           bookings.setBookingDate(bookingModel.getBookingDate());
           bookings.setCreatedAt(new Date());
           bookings.setNoOfPassengers(bookingModel.getNoOfPassengers());
           return bookingRepository.save(bookings).getBookingId();
       }catch (Exception ignored) {
           throw new CustomExceptions("Error Creating Data");
       }
    }

    @Override
    public long updateBooing(BookingModel bookingModel, long bookingId) {
        try{
            Bookings bookings = new Bookings();
            bookings.setBookingId(bookingId);
            bookings.setBookingDate(bookingModel.getBookingDate());
            bookings.setCreatedAt(new Date());
            bookings.setNoOfPassengers(bookingModel.getNoOfPassengers());
            return bookingRepository.save(bookings).getBookingId();
        }catch (Exception ignored) {
            throw new CustomExceptions("Error updating Data");
        }
    }

    @Override
    public long deleteBooking(BookingModel bookingModel, long bookingId) {
        bookingRepository.deleteById(bookingId);
        return bookingId;
    }

    @Override
    public List<Bookings> viewAllBooking() {
        return bookingRepository.getAllBookings();
    }

    @Override
    public Optional<Bookings> ViewBookingById(long bookingId) {
        return bookingRepository.findById(bookingId);
    }
}
