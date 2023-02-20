package com.example.FMS.controller;

import com.example.FMS.models.AirportModel;
import com.example.FMS.models.ResponseModel;
import com.example.FMS.services.AirPortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/airport")
public class AirportController {
    @Autowired
    AirPortService airPortService;



    @PostMapping("/create")
    ResponseModel createAirport(@RequestBody AirportModel airportModel){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(airPortService.createAirport(airportModel));
        res.message=" Created Airport";
        res.responseCode= HttpStatus.CREATED.value();
        return res;
    }

    @PostMapping("/update/{airportCode}")
    ResponseModel updateAirport(@RequestBody AirportModel airportModel, @PathVariable long airportCode){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(airPortService.updateAirport(airportModel, airportCode));
        res.message=" Created Airport";
        res.responseCode= HttpStatus.OK.value();
        return res;
    }
    @GetMapping("/viewAllAirport")
    ResponseModel viewAllAirport(){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(airPortService.ViewAllAirport());
        res.message=" Created Airport";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }
    @GetMapping("/viewAllAirportById/{airportCode}")
    ResponseModel viewAllAirportById(@PathVariable long airportCode){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(airPortService.ViewAllAirportByCode(airportCode));
        res.message=" Created Airport";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }

}
