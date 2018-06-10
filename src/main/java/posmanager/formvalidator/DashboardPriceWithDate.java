package posmanager.formvalidator;

import posmanager.formdomain.SalesAndDeatils;

import java.util.List;

/**
 * Created by dream71 on 24/10/17.
 */
public class DashboardPriceWithDate {

    private String ps;
    private List<SalesAndDeatils> shopPriceList;

    public DashboardPriceWithDate() {
    }

    public DashboardPriceWithDate(String ps, List<SalesAndDeatils> shopPriceList) {
        this.ps = ps;
        this.shopPriceList = shopPriceList;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public List<SalesAndDeatils> getShopPriceList() {
        return shopPriceList;
    }

    public void setShopPriceList(List<SalesAndDeatils> shopPriceList) {
        this.shopPriceList = shopPriceList;
    }
}
