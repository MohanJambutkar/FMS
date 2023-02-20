package com.example.FMS.controller;

import com.example.FMS.models.ResponseModel;
import com.example.FMS.models.ScheduleFlightModel;
import com.example.FMS.services.ScheduleFlightServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/scheduleFlight")
public class ScheduleFlightController {
    @Autowired
    ScheduleFlightServices scheduleFlightServices;

    @PostMapping("/add")
    ResponseModel addSchedule(@Valid @RequestBody ScheduleFlightModel scheduleFlightModel){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(scheduleFlightServices.addScheduleFlight(scheduleFlightModel));
        res.message="Schedule Created";
        res.responseCode= HttpStatus.CREATED.value();
        return res;
    }

    @PostMapping("/update/{scheduleFlightId}")
    ResponseModel updateSchedule(@Valid @RequestBody ScheduleFlightModel scheduleFlightModel,@PathVariable long scheduleFlightId){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(scheduleFlightServices.UpdateScheduleFlight(scheduleFlightModel,scheduleFlightId));
        res.message="Schedule Updated";
        res.responseCode= HttpStatus.OK.value();
        return res;
    }
    @PostMapping("/view")
    ResponseModel addSchedule(){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(scheduleFlightServices.viewScheduleFlight());
        res.message="Schedule ";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }

    @DeleteMapping("/remove/{scheduleFlightId}")
    ResponseModel removeSchedule(@Valid @RequestBody ScheduleFlightModel scheduleFlightModel,@PathVariable long scheduleFlightId){
        ResponseModel res = new ResponseModel();
        res.data= Collections.singletonList(scheduleFlightServices.removeScheduleFlight(scheduleFlightModel,scheduleFlightId));
        res.message="Schedule Updated";
        res.responseCode= HttpStatus.FOUND.value();
        return res;
    }

}
