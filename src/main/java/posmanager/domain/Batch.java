package posmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by dream71 on 31/10/17.
 */
@Entity
@Table(name = "batch_module")
public class Batch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "batch_no")
    private String batchNo;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Transient
    private String manufactureDateStr;

    @Transient
    private String expirationDateStr;



    public Batch() {
    }

    public Batch(String batchNo, LocalDate manufactureDate, LocalDate expirationDate) {
        this.batchNo = batchNo;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getManufactureDateStr() {
        return manufactureDateStr;
    }

    public void setManufactureDateStr(String manufactureDateStr) {
        this.manufactureDateStr = manufactureDateStr;
    }

    public String getExpirationDateStr() {
        return expirationDateStr;
    }

    public void setExpirationDateStr(String expirationDateStr) {
        this.expirationDateStr = expirationDateStr;
    }



    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchNo='" + batchNo + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", expirationDate=" + expirationDate +

                '}';
    }
}
