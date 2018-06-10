package posmanager.formdomain;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Marketing on 20-Jun-17.
 */
public class EditTargetMaster {


    private Integer id;


    private Integer srId;


    private Double totalAmount;



    private Integer totalQuantity;



    private String startDateString;

    private LocalDate startDate;

    public Set<EditTargetDetails> getDetailss() {
        return detailss;
    }

    public void setDetailss(Set<EditTargetDetails> detailss) {
        this.detailss = detailss;
    }

    private String endDateString;


    private LocalDate endDate;


    private Set<EditTargetDetails> detailss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrId() {
        return srId;
    }

    public void setSrId(Integer srId) {
        this.srId = srId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
