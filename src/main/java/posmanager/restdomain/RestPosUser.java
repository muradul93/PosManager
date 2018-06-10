package posmanager.restdomain;

public class RestPosUser {

    private Integer id;
    private String companyName;
    private String branchName;
    private String code;
    private String description;
    private String macAddress;

    public RestPosUser( String companyName, String branchName, String code, String description, String macAddress) {
        this.companyName = companyName;
        this.branchName = branchName;
        this.code = code;
        this.description = description;
        this.macAddress = macAddress;
    }


    public RestPosUser() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
