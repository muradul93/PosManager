package posmanager.formdomain;

/**
 * Created by root on 5/4/17.
 */
public class CustomLedger {

    private String customerCode;
    private Double bill;
    private Double totalPaid;
    private Double due;
    private Double balance;
    private Double creditLimit;
    private String customerType;

    public CustomLedger() {
    }

    public CustomLedger(String customerCode, Double bill, Double totalPaid, String customerType) {
        this.customerCode = customerCode;
        this.bill = bill;
        this.totalPaid = totalPaid;
        this.customerType = customerType;
    }

    public CustomLedger(String customerCode, Double bill, Double totalPaid, Double due, Double balance, Double creditLimit, String customerType) {
        this.customerCode = customerCode;
        this.bill = bill;
        this.totalPaid = totalPaid;
        this.due = due;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Double getDue() {
        return due;
    }

    public void setDue(Double due) {
        this.due = due;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomLedger{" +
                "customerCode='" + customerCode + '\'' +
                ", bill=" + bill +
                ", totalPaid=" + totalPaid +
                ", due=" + due +
                ", balance=" + balance +
                ", creditLimit=" + creditLimit +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
