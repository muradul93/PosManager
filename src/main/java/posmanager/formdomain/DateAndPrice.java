package posmanager.formdomain;

import java.time.LocalDate;

/**
 * Created by dream71 on 22/10/17.
 */
public class DateAndPrice {
    private LocalDate date;
    private Double totalPaid;

    public DateAndPrice() {
    }

    public DateAndPrice(LocalDate date, Double totalPaid) {
        this.date = date;
        this.totalPaid = totalPaid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }
}
