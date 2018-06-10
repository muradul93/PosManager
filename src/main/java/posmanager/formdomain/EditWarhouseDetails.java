package posmanager.formdomain;

/**
 * Created by  on 3/12/17.
 */
public class EditWarhouseDetails {

    private  Integer id;
    private  Integer mou_id;
    private  Integer product_id;
    private  Integer skuQty;
    private  Integer qty;
    private  String  mouName;
    private  String  productName;
    private String baseSkuQnty;

    public String getBaseSkuQnty() {
        return baseSkuQnty;
    }

    public void setBaseSkuQnty(String baseSkuQnty) {
        this.baseSkuQnty = baseSkuQnty;
    }





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMou_id() {
        return mou_id;
    }

    public void setMou_id(Integer mou_id) {
        this.mou_id = mou_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public String getMouName() {
        return mouName;
    }

    public void setMouName(String mouName) {
        this.mouName = mouName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
