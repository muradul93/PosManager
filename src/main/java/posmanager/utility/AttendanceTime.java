package posmanager.utility;

/**
 * Created by Murad on 11/3/2017.
 */
public enum AttendanceTime {

    INTIME("07:32:00"),
    OUTTIME("16:28:00");

    private String time;

    AttendanceTime(String time) {
        this.time = time;
    }

    public String time() {
        return time;
    }
}
