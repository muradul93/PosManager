package posmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;



@Entity
@Table(name = "hr_employee_info")
public class HrEmployeeInfo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "emp_name")
    private String empName;

    private String contact;

    @Column(name = "alt_contact")
    private String altContact;

    private String email;

    @Column(name = "national_id")
    private String nationalId;

    private String designation;

    @Column(name = "posting_area")
    private String postingArea;

    @Transient
    private String startDate;

    @Column(name = "start_date")
    private LocalDate sDate;

    @Transient
    private String endDate;

    @Column(name = "end_date")
    private LocalDate eDate;

    private Double salary;

    @Column(name = "present_address")
    private String presentAddress;

    @Column(name = "permanent_address")
    private String permanentAddress;

    private String image;

    @OneToOne(mappedBy = "hrEmployeeInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private MyUser myUser;


    @JsonIgnore
    @OneToMany(mappedBy = "hrEmployeeInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserShortCuts> userShortCuts;


    @Column(name = "department", columnDefinition = "TEXT")
    private String department;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate geteDate() {
        return eDate;
    }

    public void seteDate(LocalDate eDate) {
        this.eDate = eDate;
    }

    public LocalDate getsDate() {
        return sDate;
    }

    public void setsDate(LocalDate sDate) {
        this.sDate = sDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAltContact() {
        return altContact;
    }

    public void setAltContact(String altContact) {
        this.altContact = altContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPostingArea() {
        return postingArea;
    }

    public void setPostingArea(String postingArea) {
        this.postingArea = postingArea;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }


    public MyUser getMyUser() {
        return myUser;
    }

    public void setMyUser(MyUser myUser) {
        this.myUser = myUser;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<UserShortCuts> getUserShortCuts() {
        return userShortCuts;
    }

    public void setUserShortCuts(Set<UserShortCuts> userShortCuts) {
        this.userShortCuts = userShortCuts;
    }

}
