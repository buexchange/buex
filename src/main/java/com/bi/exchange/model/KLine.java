package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;
import java.util.Date;

public class KLine {

    private BigDecimal sequenceId;

    private Date timeStamp;

    private BigDecimal openingPrice;

    private BigDecimal closingPrice;

    private BigDecimal maxPrice;

    private BigDecimal minPrice;

    private BigDecimal volumePrice;

    private BigDecimal volumeQuantity;

    private BigDecimal lastSecondMills;


    @Primary
    @Column(name = "SEQUENCE_ID")
    public BigDecimal getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(BigDecimal sequenceId) {
        this.sequenceId = sequenceId;
    }

    @Column(name = "TIME_STAMP")
    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Column(name = "OPENING_PRICE")
    public BigDecimal getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(BigDecimal openingPrice) {
        this.openingPrice = openingPrice;
    }

    @Column(name = "CLOSING_PRICE")
    public BigDecimal getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(BigDecimal closingPrice) {
        this.closingPrice = closingPrice;
    }

    @Column(name = "MAX_PRICE")
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Column(name = "MIN_PRICE")
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    @Column(name = "VOLUME_PRICE")
    public BigDecimal getVolumePrice() {
        return volumePrice;
    }

    public void setVolumePrice(BigDecimal volumePrice) {
        this.volumePrice = volumePrice;
    }

    @Column(name = "VOLUME_QUANTITY")
    public BigDecimal getVolumeQuantity() {
        return volumeQuantity;
    }

    public void setVolumeQuantity(BigDecimal volumeQuantity) {
        this.volumeQuantity = volumeQuantity;
    }

    @Column(name = "LAST_SECOND_MILLS")
    public BigDecimal getLastSecondMills() {
        return lastSecondMills;
    }

    public void setLastSecondMills(BigDecimal lastSecondMills) {
        this.lastSecondMills = lastSecondMills;
    }
}