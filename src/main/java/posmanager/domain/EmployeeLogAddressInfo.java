package posmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by shitul on 4/3/17.
 */

@Entity
@Table(name = "employee_log_address_info")
public class EmployeeLogAddressInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="login_latitude")
    private Double loginLatitude;

    @Column(name="login_longitude")
    private Double loginLongitude;

    @Column(name="logout_latitude")
    private  Double logoutLatitude;

    @Column(name="logout_longitude")
    private Double logoutLongitude;

    @Transient
    private String loginDateTime;

    @Column(name="login_date_time")
    private LocalDate dLoginDateTime;

    @Column(name = "login_ip")
    private String loginIp;

    @Transient
    private String logoutDate;

    @Column(name = "d_logout_date")
    private LocalDate dLogoutDate;

    @Column(name = "logout_Ip")
    private String logoutIp;

    @Column(name = "login_Address")
    private String loginAddress;

    @Column(name = "logout_Address")
    private String logoutAddress;


    @Transient
    private Integer myUserId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private MyUser myUser ;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMyUserId() {
        return myUserId;
    }

    public void setMyUserId(Integer myUserId) {
        this.myUserId = myUserId;
    }

    public Double getLoginLatitude() {
        return loginLatitude;
    }

    public void setLoginLatitude(Double loginLatitude) {
        this.loginLatitude = loginLatitude;
    }

    public Double getLoginLongitude() {
        return loginLongitude;
    }

    public void setLoginLongitude(Double loginLongitude) {
        this.loginLongitude = loginLongitude;
    }

    public Double getLogoutLatitude() {
        return logoutLatitude;
    }

    public void setLogoutLatitude(Double logoutLatitude) {
        this.logoutLatitude = logoutLatitude;
    }

    public Double getLogoutLongitude() {
        return logoutLongitude;
    }

    public void setLogoutLongitude(Double logoutLongitude) {
        this.logoutLongitude = logoutLongitude;
    }

    public String getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(String loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public LocalDate getdLoginDateTime() {
        return dLoginDateTime;
    }

    public void setdLoginDateTime(LocalDate dLoginDateTime) {
        this.dLoginDateTime = dLoginDateTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(String logoutDate) {
        this.logoutDate = logoutDate;
    }

    public LocalDate getdLogoutDate() {
        return dLogoutDate;
    }

    public void setdLogoutDate(LocalDate dLogoutDate) {
        this.dLogoutDate = dLogoutDate;
    }

    public String getLogoutIp() {
        return logoutIp;
    }

    public void setLogoutIp(String logoutIp) {
        this.logoutIp = logoutIp;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public String getLogoutAddress() {
        return logoutAddress;
    }

    public void setLogoutAddress(String logoutAddress) {
        this.logoutAddress = logoutAddress;
    }

    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }
}
