package posmanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by bipulkhan on 7/2/17.
 */

@Entity
@Table(name="attendence_log")
public class AttendenceLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="user_id")
    private Integer userId;

    @Column(name="latitude")
    private String lat;

    @Column(name="longitude")
    private String lon;

    @Column(name = "attempt_date")
    private LocalDate attemptDate;

    @Transient
    private String attemptDateString;

    @Column(name = "status")
    private String status;

    @Column(name = "attempt_time")
    private String attemptTime;

    @Column(name = "device_id")
    private String deviceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public LocalDate getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(LocalDate attemptDate) {
        this.attemptDate = attemptDate;
    }

    public String getAttemptDateString() {
        return attemptDateString;
    }

    public void setAttemptDateString(String attemptDateString) {
        this.attemptDateString = attemptDateString;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(String attemptTime) {
        this.attemptTime = attemptTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
