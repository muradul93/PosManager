package posmanager.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by root on 13/4/17.
 */
@Entity
@Table(name = "organization_setting")
public class OrganizationSetting implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String companyName;
    private String companyAddress;
    private String companyPhone;
    private String currencySymbol;
    private String email;
    private String fax;
    private String image;
    private String language;
    private String returnPolicy;
    private String tax1;
    private String tax1Amount;
    private String tax2;
    private String tax2Amount;
    private String website;
    private boolean cumulative;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReturnPolicy() {
        return returnPolicy;
    }

    public void setReturnPolicy(String returnPolicy) {
        this.returnPolicy = returnPolicy;
    }

    public String getTax1() {
        return tax1;
    }

    public void setTax1(String tax1) {
        this.tax1 = tax1;
    }

    public String getTax1Amount() {
        return tax1Amount;
    }

    public void setTax1Amount(String tax1Amount) {
        this.tax1Amount = tax1Amount;
    }

    public String getTax2() {
        return tax2;
    }

    public void setTax2(String tax2) {
        this.tax2 = tax2;
    }

    public String getTax2Amount() {
        return tax2Amount;
    }

    public void setTax2Amount(String tax2Amount) {
        this.tax2Amount = tax2Amount;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isCumulative() {
        return cumulative;
    }

    public void setCumulative(boolean cumulative) {
        this.cumulative = cumulative;
    }

    @Override
    public String toString() {
        return "OrganizationSetting{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", email='" + email + '\'' +
                ", fax='" + fax + '\'' +
                ", image='" + image + '\'' +
                ", language='" + language + '\'' +
                ", returnPolicy='" + returnPolicy + '\'' +
                ", tax1='" + tax1 + '\'' +
                ", tax1Amount='" + tax1Amount + '\'' +
                ", tax2='" + tax2 + '\'' +
                ", tax2Amount='" + tax2Amount + '\'' +
                ", website='" + website + '\'' +
                ", cumulative=" + cumulative +
                '}';
    }
}
