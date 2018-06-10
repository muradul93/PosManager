package posmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Branch implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String branchName;
    private String branchCode;
    private boolean valid;
    private LocalDate expireDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyDetails companyDetails;



    @Transient
    private String expireDate_str;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getExpireDate_str() {
        return expireDate_str;
    }

    public void setExpireDate_str(String expireDate_str) {
        this.expireDate_str = expireDate_str;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }
}
