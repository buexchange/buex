package com.bi.exchange.vo;

import java.math.BigDecimal;

public class VAssetCode {

    private String name;
    private BigDecimal useable;
    private BigDecimal freeze;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUseable() {
        return useable;
    }

    public void setUseable(BigDecimal useable) {
        this.useable = useable;
    }

    public BigDecimal getFreeze() {
        return freeze;
    }

    public void setFreeze(BigDecimal freeze) {
        this.freeze = freeze;
    }
}
