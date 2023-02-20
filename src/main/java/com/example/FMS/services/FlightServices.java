package com.example.FMS.services;

import com.example.FMS.dto.flight.Flight;
import com.example.FMS.exceptions.CustomExceptions;
import com.example.FMS.models.FlightModel;
import com.example.FMS.repository.FlightRepository;
import com.example.FMS.services.interFace.IFlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServices implements IFlightServices {
    @Autowired
    FlightRepository flightRepository;

    @Override
    public long addFlight(FlightModel flightModel) {
        try{
        Flight flight = new Flight();
        flight.setCarrierName(flightModel.getCarrierName());
        flight.setFightType(flightModel.getFightType());
        flight.setSeatCapacity(flightModel.getSeatCapacity());
        return flightRepository.save(flight).getFlightNo();
     }catch (Exception e) {
        throw new CustomExceptions("Error updating Data");
    }
    }

    @Override
    public List<Flight> viewAllFlight() {
        return flightRepository.getAllFlight();
    }

    @Override
    public long updateFlight(FlightModel flightModel, long flightNo) {
        try{
        Flight flight = new Flight();
        flight.setFlightNo(flightNo);
        flight.setCarrierName(flightModel.getCarrierName());
        flight.setFightType(flightModel.getFightType());
        flight.setSeatCapacity(flightModel.getSeatCapacity());
        return flightRepository.save(flight).getFlightNo();
        }catch (Exception ignored) {
            throw new CustomExceptions("Error updating Data");
        }
    }

    @Override
    public long removeFlight(FlightModel flightModel, long flightNo) {
        flightRepository.deleteById(flightNo);
        return flightNo;
    }
}
