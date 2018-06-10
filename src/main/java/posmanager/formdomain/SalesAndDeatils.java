package posmanager.formdomain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by dream71 on 23/10/17.
 */
/*
public class SalesAndDeatils implements Serializable{
    private String name;
    private Integer quantity;
    private Double totalPrice;
    private LocalDate date;

    public SalesAndDeatils() {
    }

    public SalesAndDeatils(String name, Integer quantity, Double totalPrice, LocalDate date) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public SalesAndDeatils(String name, Integer quantity, Double totalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public SalesAndDeatils(LocalDate date,Double totalPrice) {
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}*/

public class SalesAndDeatils implements Serializable{
    private String name;
    private Integer quantity;
    private Double totalPrice;
    private LocalDate date;
    private String dateStr;

    public SalesAndDeatils() {
    }

    public SalesAndDeatils(String name, Integer quantity, Double totalPrice, LocalDate date) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public SalesAndDeatils(String name, Integer quantity, Double totalPrice, String dateStr) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.dateStr = dateStr;
    }

    public SalesAndDeatils(String name, Integer quantity, Double totalPrice, LocalDate date, String dateStr) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
        this.dateStr = dateStr;
    }

    public SalesAndDeatils(String name, Integer quantity, Double totalPrice) {
        this.name = name;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public SalesAndDeatils(LocalDate date,Double totalPrice) {
        this.totalPrice = totalPrice;
        this.date = date;
    }


    public SalesAndDeatils(Double totalPrice, String dateStr) {
        this.totalPrice = totalPrice;
        this.dateStr = dateStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

}
