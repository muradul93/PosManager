package posmanager.formdomain;



/**
 * Created by  on 3/13/17.
 */
public class AutoCompleteProduct {

    private Integer id;


    private String  skuCode;

    private String productName;


    private Integer mouId;

    private String mouName;



    private String skuQty;


    private Integer productTypeId;


    private boolean productActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getMouId() {
        return mouId;
    }

    public void setMouId(Integer mouId) {
        this.mouId = mouId;
    }

    public String getMouName() {
        return mouName;
    }

    public void setMouName(String mouName) {
        this.mouName = mouName;
    }

    public String getSkuQty() {
        return skuQty;
    }

    public void setSkuQty(String skuQty) {
        this.skuQty = skuQty;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public boolean isProductActive() {
        return productActive;
    }

    public void setProductActive(boolean productActive) {
        this.productActive = productActive;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    private String imageId;
}
