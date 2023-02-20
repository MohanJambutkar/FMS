package com.example.FMS.services;

import com.example.FMS.dto.airport.Airport;
import com.example.FMS.exceptions.CustomExceptions;
import com.example.FMS.models.AirportModel;
import com.example.FMS.repository.AirportRepository;
import com.example.FMS.services.interFace.IAirportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class AirPortService implements IAirportServices {
    @Autowired
    AirportRepository airportRepository;

    @Override
    public List<Airport> ViewAllAirport() {
        return airportRepository.getAllAirport();//.orElseThrow(()->new CustomExceptions("Data Not Found"));
    }

    @Override
    public List<Airport> ViewAllAirportByCode(long airportCode) {
        return null;
    }

    @Override
    public long createAirport(AirportModel airportModel) {
       try{
           Airport air = new Airport();
           air.setAirportName(airportModel.getAirportName());
           air.setAirportLocations(airportModel.getAirportLocations());
           air.setCreatedAt(new Date());
           return airportRepository.save(air).getAirportCode();
       }catch (Exception e){
           throw  new CustomExceptions("Error Creating Data");
       }
    }

    @Override
    public long updateAirport(AirportModel airportModel, long airportCode) {
        try{
            Airport air = new Airport();
            air.setAirportCode(airportCode);
            air.setAirportName(airportModel.getAirportName());
            air.setAirportLocations(airportModel.getAirportLocations());
            air.setModifiedAt(new Date());
            return airportRepository.save(air).getAirportCode();
        }catch (Exception e){
            throw  new CustomExceptions("Error Updating Data");
        }
    }

    @Override
    public long removeAirport(AirportModel airportModel, long airportCode) {
        airportRepository.deleteById(airportCode);
        return airportCode;
    }
}
