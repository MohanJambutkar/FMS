package com.example.FMS.services;

import com.example.FMS.dto.schedule.SchedulesFlights;
import com.example.FMS.exceptions.CustomExceptions;
import com.example.FMS.models.ScheduleFlightModel;
import com.example.FMS.repository.ScheduleFlightRepository;
import com.example.FMS.services.interFace.IScheduleFlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleFlightServices implements IScheduleFlightServices {

    @Autowired
    ScheduleFlightRepository scheduleFlightRepository;

    @Override
    public long addScheduleFlight(ScheduleFlightModel scheduleFlightModel) {
        try{
            SchedulesFlights schedulesFlights = new SchedulesFlights();
            schedulesFlights.setFlight(scheduleFlightModel.getFlight());
            schedulesFlights.setSchedule(scheduleFlightModel.getSchedule());
            schedulesFlights.setAvailableSeats(scheduleFlightModel.getAvailableSeats());

            return scheduleFlightRepository.save(schedulesFlights).getScheduleFlightId();
        }
        catch (Exception e){
            throw new CustomExceptions("Error Creating ScheduleFlights");
        }
    }

    @Override
    public long UpdateScheduleFlight(ScheduleFlightModel scheduleFlightModel, long ScheduleFlightId) {
        try{
            SchedulesFlights schedulesFlights = new SchedulesFlights();
            schedulesFlights.setScheduleFlightId(ScheduleFlightId);
            schedulesFlights.setFlight(scheduleFlightModel.getFlight());
            schedulesFlights.setSchedule(scheduleFlightModel.getSchedule());
            schedulesFlights.setAvailableSeats(scheduleFlightModel.getAvailableSeats());

            return scheduleFlightRepository.save(schedulesFlights).getScheduleFlightId();
        }
        catch (Exception e){
            throw new CustomExceptions("Error Creating ScheduleFlights");
        }
    }

    @Override
    public long removeScheduleFlight(ScheduleFlightModel scheduleFlightModel, long ScheduleFlightId) {
        return 0;
    }

    @Override
    public List<SchedulesFlights> viewScheduleFlight() {
        return scheduleFlightRepository.getAllSchedulesFlights();
    }
}
