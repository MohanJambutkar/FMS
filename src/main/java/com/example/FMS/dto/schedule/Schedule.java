package com.example.FMS.dto.schedule;

import com.example.FMS.dto.airport.Airport;
import javax.persistence.*;

@Entity
@Table(name="Schedule")
public class Schedule {

    @Id
    @Column(name = "schedule_Id")
    private long scheduleId;

    @OneToOne
    private Airport scrAirport;

    @OneToOne
    private Airport dstnAirport;

    @Column(name = "departure_date")
//	@JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private String deptDateTime;

    @Column(name = "arrival_date")
//    @JsonFormat(pattern = "mm-dd-yyyy HH:mm:ss")
    private String arrDateTime;

    public Schedule(){}

    public Schedule(long scheduleId, Airport scrAirport, Airport dstnAirport, String deptDateTime, String arrDateTime) {
        this.scheduleId = scheduleId;
        this.scrAirport = scrAirport;
        this.dstnAirport = dstnAirport;
        this.deptDateTime = deptDateTime;
        this.arrDateTime = arrDateTime;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Airport getScrAirport() {
        return scrAirport;
    }

    public void setScrAirport(Airport scrAirport) {
        this.scrAirport = scrAirport;
    }

    public Airport getDstnAirport() {
        return dstnAirport;
    }

    public void setDstnAirport(Airport dstnAirport) {
        this.dstnAirport = dstnAirport;
    }

    public String getDeptDateTime() {
        return deptDateTime;
    }

    public void setDeptDateTime(String deptDateTime) {
        this.deptDateTime = deptDateTime;
    }

    public String getArrDateTime() {
        return arrDateTime;
    }

    public void setArrDateTime(String arrDateTime) {
        this.arrDateTime = arrDateTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", scrAirport=" + scrAirport +
                ", dstnAirport=" + dstnAirport +
                ", deptDateTime='" + deptDateTime + '\'' +
                ", arrDateTime='" + arrDateTime + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
