package posmanager.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by  on 2/7/17.
 */
@Entity
@Table(name = "all_look_up")
public class AllLookUp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="all_look_up_id")
    private Integer id;

    @Column(name = "all_look_up_name")
    private String allLookUpName;

    @Column(name = "all_look_up_code")
    private String allLookUpCode;

    @Column(name = "all_look_up_module")
    private String allLookUpModule;

    @Column(name = "all_look_up_description")
    private String allLookUpDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllLookUpName() {
        return allLookUpName;
    }

    public void setAllLookUpName(String allLookUpName) {
        this.allLookUpName = allLookUpName;
    }

    public String getAllLookUpCode() {
        return allLookUpCode;
    }

    public void setAllLookUpCode(String allLookUpCode) {
        this.allLookUpCode = allLookUpCode;
    }

    public String getAllLookUpModule() {
        return allLookUpModule;
    }

    public void setAllLookUpModule(String allLookUpModule) {
        this.allLookUpModule = allLookUpModule;
    }

    public String getAllLookUpDescription() {
        return allLookUpDescription;
    }

    public void setAllLookUpDescription(String allLookUpDescription) {
        this.allLookUpDescription = allLookUpDescription;
    }
}
