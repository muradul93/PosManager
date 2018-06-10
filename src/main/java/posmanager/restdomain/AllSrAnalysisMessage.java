package posmanager.restdomain;

import posmanager.formdomain.SalesAndDeatils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Murad on 10/18/2017.
 */
public class AllSrAnalysisMessage implements Serializable{

    private Integer status;
    private String  message;
    private List<SalesAndDeatils> salesAndDeatils;
    private List<SalesAndDeatils> salesAndDeatilsdate;


    public AllSrAnalysisMessage() {
    }


    public AllSrAnalysisMessage(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public AllSrAnalysisMessage(Integer status, String message, List<SalesAndDeatils> salesAndDeatils) {
        this.status = status;
        this.message = message;
        this.salesAndDeatils = salesAndDeatils;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SalesAndDeatils> getSalesAndDeatils() {
        return salesAndDeatils;
    }

    public void setSalesAndDeatils(List<SalesAndDeatils> salesAndDeatils) {
        this.salesAndDeatils = salesAndDeatils;
    }

    public List<SalesAndDeatils> getSalesAndDeatilsdate() {
        return salesAndDeatilsdate;
    }

    public void setSalesAndDeatilsdate(List<SalesAndDeatils> salesAndDeatilsdate) {
        this.salesAndDeatilsdate = salesAndDeatilsdate;
    }
}
