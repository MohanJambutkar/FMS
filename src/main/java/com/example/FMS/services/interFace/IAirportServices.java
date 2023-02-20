package com.example.FMS.services.interFace;

import com.example.FMS.dto.airport.Airport;
import com.example.FMS.models.AirportModel;

import java.util.List;

public interface IAirportServices {
    List<Airport> ViewAllAirport();
    List<Airport> ViewAllAirportByCode(long airportCode);
    long createAirport (AirportModel airportModel);
    long updateAirport(AirportModel airportModel, long airportCode);
    long  removeAirport(AirportModel airportModel, long airportCode);

}
