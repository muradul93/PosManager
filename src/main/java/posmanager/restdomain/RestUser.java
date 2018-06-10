package posmanager.restdomain;

import java.io.Serializable;

/**
 * Created by Murad on 10/25/2017.
 */
public class RestUser implements Serializable {



    private Integer id;
    private String email;
    private String role;
    private Integer hrId;
    private Integer dealerId;
    private String userType;
    private String imageId;


    public RestUser(Integer id, String email, String role, Integer hrId,   String imageId) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.hrId = hrId;
        this.imageId = imageId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
