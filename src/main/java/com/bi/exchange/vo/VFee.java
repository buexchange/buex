package com.bi.exchange.vo;

import java.math.BigDecimal;

public class VFee {

    private Long id;

    private BigDecimal value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
