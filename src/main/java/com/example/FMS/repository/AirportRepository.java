package com.example.FMS.repository;
import com.example.FMS.dto.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AirportRepository extends JpaRepository<Airport,Long> {
    @Query("SELECT a FROM Airport a")
    List<Airport> getAllAirport();
}
