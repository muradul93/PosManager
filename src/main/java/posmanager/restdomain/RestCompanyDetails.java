package posmanager.restdomain;

import java.io.Serializable;

public class RestCompanyDetails implements Serializable{

    private Integer id;
    private String companyName;
    private String branchName;
    private String code;
    private boolean valid;
    private String expireDate_str;


    public RestCompanyDetails() {
    }

    public RestCompanyDetails( String companyName, String branchName, String code, boolean valid, String expireDate_str) {
        this.companyName = companyName;
        this.branchName = branchName;
        this.code = code;
        this.valid = valid;
        this.expireDate_str = expireDate_str;
    }

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
}
