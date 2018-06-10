package posmanager.formdomain;

/**
 * Created by  on 3/5/17.
 */
public class PriceDetailsResponseMsg {

    private boolean success;
    private boolean priceMasterIDisNone;
    private boolean productIDisNone;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isPriceMasterIDisNone() {
        return priceMasterIDisNone;
    }

    public void setPriceMasterIDisNone(boolean priceMasterIDisNone) {
        this.priceMasterIDisNone = priceMasterIDisNone;
    }

    public boolean isProductIDisNone() {
        return productIDisNone;
    }

    public void setProductIDisNone(boolean productIDisNone) {
        this.productIDisNone = productIDisNone;
    }
}
