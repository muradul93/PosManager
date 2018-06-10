package posmanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by bipulkhan on 7/2/17.
 */
@Entity
@Table(name = "attendence")
public class Attendence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "ware_house_id")
    private Integer wareHouseId;


    @Column(name = "in_time")
    private String inTime;

    @Column(name = "out_time")
    private String outTime;

    @Column(name = "date")
    private LocalDate localDate;

    @Transient
    private String localDateString;

    @Column(name = "in_attendence_log_id")
    private Integer inAttendenceLogId;

    @Column(name="out_attendence_log_id")
    private Integer outAtttendenceLogId;

    private String inTimeStatus;
    private String outTimeStatus;
    private String locationStatus;

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

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getLocalDateString() {
        return localDateString;
    }

    public void setLocalDateString(String localDateString) {
        this.localDateString = localDateString;
    }

    public Integer getInAttendenceLogId() {
        return inAttendenceLogId;
    }

    public void setInAttendenceLogId(Integer inAttendenceLogId) {
        this.inAttendenceLogId = inAttendenceLogId;
    }

    public Integer getOutAtttendenceLogId() {
        return outAtttendenceLogId;
    }

    public void setOutAtttendenceLogId(Integer outAtttendenceLogId) {
        this.outAtttendenceLogId = outAtttendenceLogId;
    }

    public String getInTimeStatus() {
        return inTimeStatus;
    }

    public void setInTimeStatus(String inTimeStatus) {
        this.inTimeStatus = inTimeStatus;
    }

    public String getOutTimeStatus() {
        return outTimeStatus;
    }

    public void setOutTimeStatus(String outTimeStatus) {
        this.outTimeStatus = outTimeStatus;
    }


    public Integer getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(Integer wareHouseId) {
        this.wareHouseId = wareHouseId;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }
}