package posmanager.formdomain;

/**
 * Created by root on 3/13/17.
 */
public class FInvoiceDetails {

    private Integer id;

    private Integer product;

    private Integer reqQty;

    private Integer remQty;

    private Integer reqSkuQty;

    private Integer delveryQty;

    private Integer deleverySkuqty;

    private String pName;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getReqQty() {
        return reqQty;
    }

    public void setReqQty(Integer reqQty) {
        this.reqQty = reqQty;
    }

    public Integer getRemQty() {
        return remQty;
    }

    public void setRemQty(Integer remQty) {
        this.remQty = remQty;
    }

    public Integer getReqSkuQty() {
        return reqSkuQty;
    }

    public void setReqSkuQty(Integer reqSkuQty) {
        this.reqSkuQty = reqSkuQty;
    }

    public Integer getDelveryQty() {
        return delveryQty;
    }

    public void setDelveryQty(Integer delveryQty) {
        this.delveryQty = delveryQty;
    }

    public Integer getDeleverySkuqty() {
        return deleverySkuqty;
    }

    public void setDeleverySkuqty(Integer deleverySkuqty) {
        this.deleverySkuqty = deleverySkuqty;
    }
}
