package posmanager.formdomain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by dream71 on 2/11/17.
 */
public class RawBatchData implements Serializable {
    private String batchNo;
    private String eDate;
    private String mDate;

    public RawBatchData() {
    }

    public RawBatchData(String batchNo, LocalDate eDate, LocalDate mDate) {
        this.batchNo = batchNo;
        this.eDate = "" + eDate.getDayOfMonth() + ' ' + eDate.getMonth() + ' ' + eDate.getYear();
        this.mDate = "" + mDate.getDayOfMonth() + ' ' + mDate.getMonth() + ' ' + mDate.getYear();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String geteDate() {
        return eDate;
    }

    public void seteDate(String eDate) {
        this.eDate = eDate;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}