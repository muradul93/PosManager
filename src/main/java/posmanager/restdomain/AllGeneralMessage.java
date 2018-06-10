package posmanager.restdomain;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Murad on 10/18/2017.
 */
public class AllGeneralMessage<T> implements Serializable {

    private Integer status;
    private String  message;
    private RestCompanyDetails restCompanyDetails;
    private T restObjectData;
    private List<T> restListData;
    private Page<T> restPageData;


    public AllGeneralMessage(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public AllGeneralMessage(Integer status, String message, T restObjectData) {
        this.status = status;
        this.message = message;
        this.restObjectData = restObjectData;
    }

    public AllGeneralMessage(Integer status, String message, List<T> restListData) {
        this.status = status;
        this.message = message;
        this.restListData = restListData;
    }

    public AllGeneralMessage(Integer status, String message, Page<T> restPageData) {
        this.status = status;
        this.message = message;
        this.restPageData = restPageData;
    }

    public AllGeneralMessage(Integer status, String message, RestCompanyDetails restCompanyDetails) {
        this.status = status;
        this.message = message;
        this.restCompanyDetails = restCompanyDetails;
    }

    public AllGeneralMessage(){}

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

    public List<T> getRestListData() {
        return restListData;
    }

    public void setRestListData(List<T> restListData) {
        this.restListData = restListData;
    }

    public Page<T> getRestPageData() {
        return restPageData;
    }

    public void setRestPageData(Page<T> restPageData) {
        this.restPageData = restPageData;
    }

    public T getRestObjectData() {
        return restObjectData;
    }

    public void setRestObjectData(T restObjectData) {
        this.restObjectData = restObjectData;
    }

    public RestCompanyDetails getRestCompanyDetails() {
        return restCompanyDetails;
    }

    public void setRestCompanyDetails(RestCompanyDetails restCompanyDetails) {
        this.restCompanyDetails = restCompanyDetails;
    }
}