package posmanager.formdomain;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by root on 3/9/17.
 */

public class FInvoiceMaster {

    private Integer id;

    private String invoiceNo;



    private Integer invoiceId;

    private String reqMasterId;

    private String saleType;

    private String customerCode;

    private String customerCodeId;

    private String status;

    private String warhouseID;

    private String carNO;

    private String doNo;

    private LocalDate invoiceDate;

    private String createdBy;

    private Set<FInvoiceDetails> invoiceDetailss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getReqMasterId() {
        return reqMasterId;
    }

    public void setReqMasterId(String reqMasterId) {
        this.reqMasterId = reqMasterId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerCodeId() {
        return customerCodeId;
    }

    public void setCustomerCodeId(String customerCodeId) {
        this.customerCodeId = customerCodeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Set<FInvoiceDetails> getInvoiceDetailss() {
        return invoiceDetailss;
    }

    public void setInvoiceDetailss(Set<FInvoiceDetails> invoiceDetailss) {
        this.invoiceDetailss = invoiceDetailss;
    }

    public String getWarhouseID() {
        return warhouseID;
    }

    public void setWarhouseID(String warhouseID) {
        this.warhouseID = warhouseID;
    }

    public String getCarNO() {
        return carNO;
    }

    public void setCarNO(String carNO) {
        this.carNO = carNO;
    }

    public String getDoNo() {
        return doNo;
    }

    public void setDoNo(String doNo) {
        this.doNo = doNo;
    }
}
