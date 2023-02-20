package com.example.FMS.dto.airport;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    private long airportCode;

    private String airportLocations;

    private String airportName;
    private Date createdAt;

    private Date modifiedAt;

    public long getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(long airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportLocations() {
        return airportLocations;
    }

    public void setAirportLocations(String airportLocations) {
        this.airportLocations = airportLocations;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
