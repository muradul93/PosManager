package posmanager.formdomain;

/**
 * Created by bipulkhan on 6/8/17.
 */
public class DiscountObject {

    private Double dicountMaxLimitaion;
    private Integer priority;
    private boolean discountOnAll;
    private boolean dicountTypePrice;
    private Double discountLimit;
    private boolean priceTypeFixed;
    private boolean quantityType;
    private Double discountAmount;

    public Double getDicountMaxLimitaion() {
        return dicountMaxLimitaion;
    }

    public void setDicountMaxLimitaion(Double dicountMaxLimitaion) {
        this.dicountMaxLimitaion = dicountMaxLimitaion;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean isDiscountOnAll() {
        return discountOnAll;
    }

    public void setDiscountOnAll(boolean discountOnAll) {
        this.discountOnAll = discountOnAll;
    }

    public boolean isDicountTypePrice() {
        return dicountTypePrice;
    }

    public void setDicountTypePrice(boolean dicountTypePrice) {
        this.dicountTypePrice = dicountTypePrice;
    }

    public Double getDiscountLimit() {
        return discountLimit;
    }

    public void setDiscountLimit(Double discountLimit) {
        this.discountLimit = discountLimit;
    }

    public boolean isPriceTypeFixed() {
        return priceTypeFixed;
    }

    public void setPriceTypeFixed(boolean priceTypeFixed) {
        this.priceTypeFixed = priceTypeFixed;
    }

    public boolean isQuantityType() {
        return quantityType;
    }

    public void setQuantityType(boolean quantityType) {
        this.quantityType = quantityType;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "DiscountObject{" +
                "dicountMaxLimitaion=" + dicountMaxLimitaion +
                ", priority=" + priority +
                ", discountOnAll=" + discountOnAll +
                ", dicountTypePrice=" + dicountTypePrice +
                ", discountLimit=" + discountLimit +
                ", priceTypeFixed=" + priceTypeFixed +
                ", quantityType=" + quantityType +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
