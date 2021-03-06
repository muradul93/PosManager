package posmanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class CompanyDetails implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String companyName;
    private String branchName;
    private String code;
    private boolean valid;
    private LocalDate expireDate;
    private Integer numberOfBranch;

    @OneToMany(mappedBy = "companyDetails", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Branch> branches;

    @Transient
    private String expireDate_str;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getNumberOfBranch() {
        return numberOfBranch;
    }

    public void setNumberOfBranch(Integer numberOfBranch) {
        this.numberOfBranch = numberOfBranch;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }
}
