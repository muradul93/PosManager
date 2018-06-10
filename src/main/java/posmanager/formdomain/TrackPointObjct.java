package posmanager.formdomain;

/**
 * Created by  on 4/9/17.
 */
public class TrackPointObjct {

    private String oderLocationName;
    private Float  lat;
    private Float  lon;
    private String  time;
    private String  date;

    public String getOderLocationName() {
        return oderLocationName;
    }

    public void setOderLocationName(String oderLocationName) {
        this.oderLocationName = oderLocationName;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
