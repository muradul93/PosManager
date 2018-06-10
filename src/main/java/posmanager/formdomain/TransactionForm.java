package posmanager.formdomain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dream71 on 28/9/17.
 */
public class TransactionForm implements Serializable {

    private  Integer id;
    private String status;
    private String batchNO;
    private Integer form;
    private Integer to;
    private List<TransactionDetailsForm> transactionDetailsForms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBatchNO() {
        return batchNO;
    }

    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public List<TransactionDetailsForm> getTransactionDetailsForms() {
        return transactionDetailsForms;
    }

    public void setTransactionDetailsForms(List<TransactionDetailsForm> transactionDetailsForms) {
        this.transactionDetailsForms = transactionDetailsForms;
    }

    @Override
    public String toString() {
        return "TransactionForm{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", batchNO='" + batchNO + '\'' +
                ", form=" + form +
                ", to=" + to +
                '}';
    }
}
