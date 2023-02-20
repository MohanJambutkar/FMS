package com.example.FMS.controller;

import com.example.FMS.models.BookingModel;
import com.example.FMS.models.ResponseModel;
import com.example.FMS.services.BookingServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingServices bookingServices;

    @PostMapping("/add")
    ResponseModel addBooking(@Valid @RequestBody BookingModel bookingModel){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(bookingServices.createBooking(bookingModel));
        res.message="Booking Added";
        res.responseCode= HttpStatus.CREATED.value();
        return res;
    }

    @PostMapping("/update/{bookingId}")
    ResponseModel updateBooking(@Valid @RequestBody BookingModel bookingModel, @PathVariable long bookingId){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(bookingServices.updateBooing(bookingModel,bookingId));
        res.message="Booking updated";
        res.responseCode= HttpStatus.OK.value();
        return res;
    }
    @GetMapping("/view")
    ResponseModel viewBooking(){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(bookingServices.viewAllBooking());
        res.message="Booking Added";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }
    @GetMapping("/view/{bookingId}")
    ResponseModel viewBookingById(@PathVariable long bookingId){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(bookingServices.ViewBookingById(bookingId));
        res.message="Booking Added";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }
    @DeleteMapping("/remove/{bookingId}")
    ResponseModel removeBookingById(@RequestBody BookingModel bookingModel,@PathVariable long bookingId){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(bookingServices.deleteBooking(bookingModel, bookingId));
        res.message="Booking Removed";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }
}
