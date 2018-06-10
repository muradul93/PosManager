package posmanager.formdomain;

import posmanager.domain.HrEmployeeInfo;

import java.io.Serializable;

/**
 * Created by dream71 on 20/11/17.
 */
public class BreakDown implements Serializable {
    private HrEmployeeInfo hrEmployeeInfo;
    private Double due;
    private Double total;
    private Double paid;

    public BreakDown() {
    }

    public BreakDown(HrEmployeeInfo hrEmployeeInfo, Double due, Double total, Double paid) {
        this.hrEmployeeInfo = hrEmployeeInfo;
        this.due = due;
        this.total = total;
        this.paid = paid;
    }

    public HrEmployeeInfo getHrEmployeeInfo() {
        return hrEmployeeInfo;
    }

    public void setHrEmployeeInfo(HrEmployeeInfo hrEmployeeInfo) {
        this.hrEmployeeInfo = hrEmployeeInfo;
    }

    public Double getDue() {
        return due;
    }

    public void setDue(Double due) {
        this.due = due;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "BreakDown{" +
                "hrEmployeeInfo=" + hrEmployeeInfo +
                ", due=" + due +
                ", total=" + total +
                '}';
    }
}