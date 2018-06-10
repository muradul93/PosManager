package posmanager.formdomain;

import java.util.Set;

/**
 * Created by  on 3/13/17.
 */
public class EditRequisitionMaster {

    private Integer id;

    private String requisitionNumber;

    private String salesType;

    private String customerCode;

    private String createdBy;

    private Double totalItemDisc;

    private Double totalVat;

    private Double netPayable;

    private Double paidAmount;

    private String status;

    private String payMode;

    private String payDescription;

    private String comment;

    private String reDate;

    private String expTranDate;

    Set<EditRequisitionDetails> detailss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Double getTotalItemDisc() {
        return totalItemDisc;
    }

    public void setTotalItemDisc(Double totalItemDisc) {
        this.totalItemDisc = totalItemDisc;
    }

    public Double getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(Double totalVat) {
        this.totalVat = totalVat;
    }

    public Double getNetPayable() {
        return netPayable;
    }

    public void setNetPayable(Double netPayable) {
        this.netPayable = netPayable;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPayDescription() {
        return payDescription;
    }

    public void setPayDescription(String payDescription) {
        this.payDescription = payDescription;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReDate() {
        return reDate;
    }

    public void setReDate(String reDate) {
        this.reDate = reDate;
    }

    public String getExpTranDate() {
        return expTranDate;
    }

    public void setExpTranDate(String expTranDate) {
        this.expTranDate = expTranDate;
    }

    public Set<EditRequisitionDetails> getDetailss() {
        return detailss;
    }

    public void setDetailss(Set<EditRequisitionDetails> detailss) {
        this.detailss = detailss;
    }
}
