package posmanager.formdomain;

/**
 * Created by  on 5/11/17.
 */
public class DamageReturnProductObject {

    private Integer productId;
    private Double damageValue;
    private Integer qty;
    private Integer skuQty;
    private Double totalBalance;
    private Integer priceDetailsId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(Double damageValue) {
        this.damageValue = damageValue;
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

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Integer getPriceDetailsId() {
        return priceDetailsId;
    }

    public void setPriceDetailsId(Integer priceDetailsId) {
        this.priceDetailsId = priceDetailsId;
    }
}
