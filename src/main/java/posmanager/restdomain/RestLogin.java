package posmanager.restdomain;

import java.io.Serializable;

/**
 * Created by dream71 on 19/10/17.
 */
public class RestLogin implements Serializable {

    private String username;
    private String password;

    public RestLogin() {
    }

    public RestLogin(String username, String password) {
        this.username = username;
        this.password = password;
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
