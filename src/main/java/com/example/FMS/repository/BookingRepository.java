package com.example.FMS.repository;

import com.example.FMS.dto.booking.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Bookings,Long> {

    @Query("SELECT a FROM Bookings a")
    List<Bookings> getAllBookings();
}
