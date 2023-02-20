package com.example.FMS.controller;

import com.example.FMS.models.BookingModel;
import com.example.FMS.models.FlightModel;
import com.example.FMS.models.ResponseModel;
import com.example.FMS.services.FlightServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightServices flightServices;
    @PostMapping("/addFlight")
    ResponseModel addFlight(@Valid @RequestBody FlightModel flightModel){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(flightServices.addFlight(flightModel));
        res.message="Flight added";
        res.responseCode= HttpStatus.CREATED.value();
        return res;
    }

    @PostMapping("/updateFlight/{flightNo}")
    ResponseModel addFlight(@Valid @RequestBody FlightModel flightModel, @PathVariable long flightNo){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(flightServices.updateFlight(flightModel,flightNo));
        res.message="Flight updated";
        res.responseCode= HttpStatus.OK.value();
        return res;
    }
    @GetMapping("view")
    ResponseModel viewFlight(){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(flightServices.viewAllFlight());
        res.message="Flight ";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }
    @DeleteMapping("/remove/{flightNo}")
    ResponseModel removeBookingById(@RequestBody FlightModel flightModel, @PathVariable long flightNo){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(flightServices.removeFlight(flightModel, flightNo));
        res.message="Booking Removed";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }
}
