package posmanager.restdomain;

/**
 * Created by shitul on 4/3/17.
 */
public class UserLogoutObject {

    private Integer loginID;
    private Double logoutLatitude;
    private Double logoutLongitude;
    private String logoutDateTime;
    private String logoutIp;
    private String logoutAddress;


    public Integer getLoginID() {
        return loginID;
    }

    public void setLoginID(Integer loginID) {
        this.loginID = loginID;
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

    public String getLogoutDateTime() {
        return logoutDateTime;
    }

    public void setLogoutDateTime(String logoutDateTime) {
        this.logoutDateTime = logoutDateTime;
    }

    public String getLogoutIp() {
        return logoutIp;
    }

    public void setLogoutIp(String logoutIp) {
        this.logoutIp = logoutIp;
    }

    public String getLogoutAddress() {
        return logoutAddress;
    }

    public void setLogoutAddress(String logoutAddress) {
        this.logoutAddress = logoutAddress;
    }
}
