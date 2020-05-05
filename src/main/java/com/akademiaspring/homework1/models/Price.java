package com.akademiaspring.homework1.models;

import java.math.BigDecimal;

public class Price {

    private BigDecimal price;

    public Price(BigDecimal price) {
        this.price = price;
    }

    public Price() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
