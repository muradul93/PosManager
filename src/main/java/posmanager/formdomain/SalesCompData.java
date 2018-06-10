package posmanager.formdomain;

import java.io.Serializable;

/**
 * Created by dream71 on 19/11/17.
 */
public class SalesCompData implements Serializable {
    private String label;
    private Double thMonth;
    private Double lmMonth;

    public SalesCompData() {
    }

    public SalesCompData(String label, Double thMonth, Double lmMonth) {
        this.label = label;
        this.thMonth = thMonth;
        this.lmMonth = lmMonth;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getThMonth() {
        return thMonth;
    }

    public void setThMonth(Double thMonth) {
        this.thMonth = thMonth;
    }

    public Double getLmMonth() {
        return lmMonth;
    }

    public void setLmMonth(Double lmMonth) {
        this.lmMonth = lmMonth;
    }

    @Override
    public String toString() {
        return "SalesCompData{" +
                "label='" + label + '\'' +
                ", thMonth=" + thMonth +
                ", lmMonth=" + lmMonth +
                '}';
    }
}