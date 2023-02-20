package com.example.FMS.dto.schedule;

import com.example.FMS.dto.flight.Flight;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SchedulesFlights {
    @Id
    @Column(name="schedule_flight_id")
    private long scheduleFlightId;

    @OneToOne
    private Flight flight;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @OneToOne
    private Schedule schedule;

    public SchedulesFlights() {

    }

    public SchedulesFlights(long scheduleFlightId, Flight flight, Integer availableSeats, Schedule schedule) {
        this.scheduleFlightId = scheduleFlightId;
        this.flight = flight;
        this.availableSeats = availableSeats;
        this.schedule = schedule;
    }

    public long getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(long scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
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
}
