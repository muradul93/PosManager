package posmanager.formdomain;

import java.util.List;

/**
 * Created by  on 5/15/17.
 */
public class DealerSelectObjectDamageRequest {
    private Integer id;
    private String srName;
    private List<DamageProduct> damageProductList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
    }

    public List<DamageProduct> getDamageProductList() {
        return damageProductList;
    }

    public void setDamageProductList(List<DamageProduct> damageProductList) {
        this.damageProductList = damageProductList;
    }
}
