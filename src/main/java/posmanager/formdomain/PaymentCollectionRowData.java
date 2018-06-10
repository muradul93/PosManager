package posmanager.formdomain;

/**
 * Created by dream71 on 14/11/17.
 */
public class PaymentCollectionRowData{

    private String sr;
    private String customer;
    private String van;
    private String date;
    private Integer noOfPayment;
    private Double total;
    private Double due;
    private Double paidAmount;
    private Double customerBalance;


    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getVan() {
        return van;
    }

    public void setVan(String van) {
        this.van = van;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNoOfPayment() {
        return noOfPayment;
    }

    public void setNoOfPayment(Integer noOfPayment) {
        this.noOfPayment = noOfPayment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDue() {
        return due;
    }

    public void setDue(Double due) {
        this.due = due;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(Double customerBalance) {
        this.customerBalance = customerBalance;
    }
}