package posmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by  on 4/27/17.
 */

@Entity
@Table(name="user_short_cuts")
public class UserShortCuts implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "link_name")
    private String linkName;

    @Column(name = "path")
    private String path;

    @Column(name="icon_path")
    private String icon;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private HrEmployeeInfo hrEmployeeInfo;


    public UserShortCuts() {
    }

   public UserShortCuts(HrEmployeeInfo hrEmployeeInfo, String linkName, String path, String icon) {
        this.hrEmployeeInfo = hrEmployeeInfo;
        this.linkName = linkName;
        this.path = path;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public HrEmployeeInfo getHrEmployeeInfo() {
        return hrEmployeeInfo;
    }

    public void setHrEmployeeInfo(HrEmployeeInfo hrEmployeeInfo) {
        this.hrEmployeeInfo = hrEmployeeInfo;
    }
}
