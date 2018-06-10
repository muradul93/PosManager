package posmanager.formdomain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by dream71 on 2/5/17.
 */
public class LocationForm  {

    private Integer locationId;

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min=2, max=30)
    @Column(name = "code")
    private String code;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    private String parentId;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
