package com.fruitprices.fruit_totalprice_service.bean;

import org.springframework.stereotype.Component;

@Component
public class FruitTotalPrice {

    private Integer id;
    private String fruit;
    private Double fmp;

    private String month;
    private Double quantity;
    private Double totalPrice;
    private String environment;

    public FruitTotalPrice() {

    }

    public FruitTotalPrice(Integer id, String fruit, Double fmp, String month, Double quantity, String environment, Double totalPrice) {
        this.id = id;
        this.fruit = fruit;
        this.fmp = fmp;
        this.month = month;
        this.quantity = quantity;
        this.environment = environment;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public Double getFmp() {
        return fmp;
    }

    public void setFmp(Double fmp) {
        this.fmp = fmp;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
