package posmanager.formdomain;

/**
 * Created by  on 5/15/17.
 */
public class DamageProduct {

    private Integer id;
    private String name;
    private Integer qty;
    private Integer skuQty;
    private Integer skuUnit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getSkuQty() {
        return skuQty;
    }

    public void setSkuQty(Integer skuQty) {
        this.skuQty = skuQty;
    }

    public Integer getSkuUnit() {
        return skuUnit;
    }

    public void setSkuUnit(Integer skuUnit) {
        this.skuUnit = skuUnit;
    }
}
