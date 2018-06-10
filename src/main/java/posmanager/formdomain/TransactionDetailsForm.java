package posmanager.formdomain;

import java.io.Serializable;

/**
 * Created by dream71 on 28/9/17.
 */
public class TransactionDetailsForm implements Serializable {

    private String batchName;
    private String productName;
    private Integer quantity;

    public TransactionDetailsForm(String batchName, String productName, Integer quantity) {
        this.batchName = batchName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public TransactionDetailsForm() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    @Override
    public String toString() {
        return "TransactionDetailsForm{" +
                "batchName='" + batchName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
