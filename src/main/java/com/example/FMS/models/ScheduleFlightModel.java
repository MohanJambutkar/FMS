package com.example.FMS.models;

import com.example.FMS.dto.flight.Flight;
import com.example.FMS.dto.schedule.Schedule;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class ScheduleFlightModel{
        @NotNull(message = "ScheduleFlight is required")
        private long scheduleFlightId;
        @NotNull(message = "Available Seat is required")
        private Integer availableSeats;
        private Schedule schedule;
        private Flight flight;

    public long getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(long scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
