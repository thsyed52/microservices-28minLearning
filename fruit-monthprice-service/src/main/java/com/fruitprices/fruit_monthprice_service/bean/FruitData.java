package com.fruitprices.fruit_monthprice_service.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class FruitData {

    @Id
    private Integer id;
    private String fruit;
    private Double fmp;

    @Column(name = "MONTH_NAME")
    private String month;

    @Transient
    private String environment;

    /* constructors */
    public FruitData() {
    }

    public FruitData(Integer id, String fruit, Double fmp, String month) {
        super();
        this.id = id;
        this.fruit = fruit;
        this.fmp = fmp;
        this.month = month;
    }

    /* Getters & Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
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
}
