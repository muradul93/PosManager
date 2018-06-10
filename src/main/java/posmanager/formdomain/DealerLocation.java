package posmanager.formdomain;

/**
 * Created by bipulkhan on 6/18/17.
 */
public class DealerLocation {

    private String dealerName;
    private String dealerLocationName;
    private String dealerCode;
    private Float latitude;
    private Float longitude;


    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerLocationName() {
        return dealerLocationName;
    }

    public void setDealerLocationName(String dealerLocationName) {
        this.dealerLocationName = dealerLocationName;
    }

    public String getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(String dealerCode) {
        this.dealerCode = dealerCode;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
