package posmanager.formdomain;

import java.util.List;

/**
 * Created by bipulkhan on 6/8/17.
 */
public class ProductDetails {

    private Integer productId;
    private String mou;
    private String skuQty;
    private String price;
    private List<DiscountObject> discountObjects;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getMou() {
        return mou;
    }

    public void setMou(String mou) {
        this.mou = mou;
    }

    public String getSkuQty() {
        return skuQty;
    }

    public void setSkuQty(String skuQty) {
        this.skuQty = skuQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<DiscountObject> getDiscountObjects() {
        return discountObjects;
    }

    public void setDiscountObjects(List<DiscountObject> discountObjects) {
        this.discountObjects = discountObjects;
    }
}
