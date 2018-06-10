package posmanager.restdomain;

/**
 * Created by bipulkhan on 7/2/17.
 */
public class AttendanceResponseMessage {

    private Integer staus;
    private String  messege;
    private String attendenceStatus;
    private String attendenceMessage;


    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getAttendenceStatus() {
        return attendenceStatus;
    }

    public void setAttendenceStatus(String attendenceStatus) {
        this.attendenceStatus = attendenceStatus;
    }

    public String getAttendenceMessage() {
        return attendenceMessage;
    }

    public void setAttendenceMessage(String attendenceMessage) {
        this.attendenceMessage = attendenceMessage;
    }
}
