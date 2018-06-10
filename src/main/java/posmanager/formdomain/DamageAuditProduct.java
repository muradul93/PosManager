package posmanager.formdomain;

import java.io.Serializable;

/**
 * Created by  on 5/3/17.
 */
public class DamageAuditProduct implements Serializable {

    private Integer productId;

    private Integer skuQty;

    private Integer qty;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSkuQty() {
        return skuQty;
    }

    public void setSkuQty(Integer skuQty) {
        this.skuQty = skuQty;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
