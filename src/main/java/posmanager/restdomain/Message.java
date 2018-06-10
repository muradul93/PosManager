package posmanager.restdomain;

/**
 * Created by shitul on 4/3/17.
 */
public class Message {

    private Integer Staus;
    private String  messege;

    public Integer getStaus() {
        return Staus;
    }

    public void setStaus(Integer staus) {
        Staus = staus;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }
}
