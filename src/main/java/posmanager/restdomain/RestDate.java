package posmanager.restdomain;

import java.io.Serializable;

/**
 * Created by Murad on 11/22/2017.
 */

public class RestDate implements Serializable {

    private  String startDate;
    private  String endDate;
    private  Integer customerId;


    public RestDate() {
    }

    public RestDate(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
