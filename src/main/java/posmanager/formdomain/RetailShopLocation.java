package posmanager.formdomain;

/**
 * Created by bipulkhan on 6/18/17.
 */
public class RetailShopLocation {

    private String retailShopName;
    private String retailShopLocationName;
    private String retailShopCode;
    private Float latitude;
    private Float longitude;


    public String getRetailShopName() {
        return retailShopName;
    }

    public void setRetailShopName(String retailShopName) {
        this.retailShopName = retailShopName;
    }

    public String getRetailShopLocationName() {
        return retailShopLocationName;
    }

    public void setRetailShopLocationName(String retailShopLocationName) {
        this.retailShopLocationName = retailShopLocationName;
    }

    public String getRetailShopCode() {
        return retailShopCode;
    }

    public void setRetailShopCode(String retailShopCode) {
        this.retailShopCode = retailShopCode;
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
