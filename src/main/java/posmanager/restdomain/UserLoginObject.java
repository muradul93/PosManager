package posmanager.restdomain;

/**
 * Created by shitul on 4/3/17.
 */
public class UserLoginObject {


    private String username;
    private String password;
    private Double loginLatitude;
    private Double loginLongitude;
    private String loginDateTime;
    private String loginIp;
    private String loginAddress;

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

    public String getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(String loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
