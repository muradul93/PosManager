package posmanager.formdomain;

import java.util.Set;

/**
 * Created by  on 3/12/17.
 */
public class EditWarhouseMaster {
    private  Integer id;
    private  String from;
    private  String to;
    private  String  batchNo;
    private  String  status;
    private Set<EditWarhouseDetails> detailss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<EditWarhouseDetails> getDetailss() {
        return detailss;
    }

    public void setDetailss(Set<EditWarhouseDetails> detailss) {
        this.detailss = detailss;
    }
}
