package com.example.FMS.services.interFace;

import com.example.FMS.dto.schedule.SchedulesFlights;
import com.example.FMS.models.ScheduleFlightModel;

import java.util.List;

public interface IScheduleFlightServices {
    long  addScheduleFlight(ScheduleFlightModel scheduleFlightModel);
    long  UpdateScheduleFlight(ScheduleFlightModel scheduleFlightModel,long ScheduleFlightId);
    long  removeScheduleFlight(ScheduleFlightModel scheduleFlightModel,long ScheduleFlightId);
    List<SchedulesFlights> viewScheduleFlight();

}
