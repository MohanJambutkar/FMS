package com.example.FMS.services.interFace;

import com.example.FMS.dto.flight.Flight;
import com.example.FMS.models.FlightModel;

import java.util.List;

public interface IFlightServices {

    long addFlight(FlightModel flightModel);
    List<Flight> viewAllFlight();
    long updateFlight(FlightModel flightModel, long flightNo);
    long removeFlight(FlightModel flightModel, long flightNo);

}
