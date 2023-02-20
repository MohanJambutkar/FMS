package com.example.FMS.repository;

import com.example.FMS.dto.flight.Flight;
import com.example.FMS.dto.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {


    @Query("SELECT f FROM Flight f")
     List<Flight> getAllFlight();
}
