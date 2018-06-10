package posmanager.formdomain;

import lombok.ToString;

/**
 * Created by dream71 on 2/11/17.
 */
@ToString
public class FactoryRawProduct{
    private String productName;
    private String unitName;
    private String skuCode;

    public FactoryRawProduct() {
    }

    public FactoryRawProduct(String productName, String unitName, String skuCode) {
        this.productName = productName;
        this.unitName = unitName;
        this.skuCode = skuCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
}