package com.example.FMS.repository;

import com.example.FMS.dto.schedule.SchedulesFlights;
import com.example.FMS.dto.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ScheduleFlightRepository extends JpaRepository<SchedulesFlights,Long> {
    @Query("SELECT shf FROM SchedulesFlights shf")
    List<SchedulesFlights>  getAllSchedulesFlights();
}
