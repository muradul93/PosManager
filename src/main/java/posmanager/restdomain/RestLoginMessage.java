package posmanager.restdomain;

import java.io.Serializable;

/**
 * Created by dream71 on 19/10/17.
 */
public class RestLoginMessage implements Serializable{

    private Integer status;

    private String  messege;

    private RestUser restUser;

    public RestLoginMessage() {
    }

    public RestLoginMessage(Integer status, String messege) {
        this.status = status;
        this.messege = messege;
    }

    public RestLoginMessage(Integer status, String messege, RestUser restUser) {
        this.status = status;
        this.messege = messege;
        this.restUser = restUser;
    }

    public RestUser getRestUser() {
        return restUser;
    }

    public void setRestUser(RestUser restUser) {
        this.restUser = restUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

}
