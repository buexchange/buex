package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.Table;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

@Table(scheme = "EX_FEE")
public class Fee {

    private Long id;
    private String assetcode;
    private BigDecimal drawfee;
    private BigDecimal tradefee;

    @Primary
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ASSETCODE")
    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    @Column(name = "DRAWFEE")
    public BigDecimal getDrawfee() {
        return drawfee;
    }

    public void setDrawfee(BigDecimal drawfee) {
        this.drawfee = drawfee;
    }

    @Column(name = "TRADEFEE")
    public BigDecimal getTradefee() {
        return tradefee;
    }

    public void setTradefee(BigDecimal tradefee) {
        this.tradefee = tradefee;
    }
}
