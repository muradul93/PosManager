package posmanager.formdomain;

import java.time.LocalDate;

/**
 * Created by bipulkhan on 7/5/17.
 */

public class AttendanceObjectDetails {

    private Integer id;
    private Integer pid;
    private String srName;
    private String wareHouseName;
    private String inTime;
    private String outTime;
    private LocalDate date;
    private String lat;
    private String lon;
    private String inTimeStatus;
    private String outTimeStatus;
    private String locationStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }
}