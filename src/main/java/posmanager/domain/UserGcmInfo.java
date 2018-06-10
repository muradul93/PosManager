package posmanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by shitul on 4/3/17.
 */

@Entity
@Table(name = "user_gcm_info")
public class UserGcmInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "device_Id")
    private String deviceid;

    @Column(name = "device_token")
    private String devicedToken;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name="version_code")
    private String versionCode;

    @Column(name="email")
    private String email;

    @Column(name="user_IP")
    private String userIp;

    @Transient
    private String date;

    @Column(name="date")
    private LocalDate dDate;

    @Column(name="updateTimeStamp")
    private String updateTimeStamp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicedToken() {
        return devicedToken;
    }

    public void setDevicedToken(String devicedToken) {
        this.devicedToken = devicedToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDate getdDate() {
        return dDate;
    }

    public void setdDate(LocalDate dDate) {
        this.dDate = dDate;
    }

    public String getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(String updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
