package posmanager.formdomain;

/**
 * Created by root on 21/5/17.
 */

public class Top10Product {
    private String name;
    private Integer volume;
    private double amount;

    public Top10Product(String name, Integer volume) {
        this.name = name;
        this.volume = volume;
    }

    public Top10Product(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Top10Product(String name, Integer volume, double amount) {
        this.name = name;
        this.volume = volume;
        this.amount = amount;
    }

    public Top10Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
