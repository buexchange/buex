package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@Table(scheme = "EX_TRANSACTION")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class Transaction extends BaseModel{

    private Long id;
    private Long userId;
    private Long orderId;
    private Long sellOrderId;
    private Long buyOrderId;
    private Long sellUserId;
    private Long buyUserId;
    private Date transactionTime;
    private String transactionType;
    private BigDecimal transactionPrice;
    private BigDecimal transactionAmount;
    private Date showTransactionTime;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name = "SELL_ORDER_ID")
    public Long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    @Column(name = "BUY_ORDER_ID")
    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    @Column(name = "SELL_USER_ID")
    public Long getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(Long sellUserId) {
        this.sellUserId = sellUserId;
    }

    @Column(name = "BUY_USER_ID")
    public Long getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Long buyUserId) {
        this.buyUserId = buyUserId;
    }

    @Column(name = "TRANSACTION_TIME")
    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Column(name = "TRANSACTION_TYPE")
    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Column(name = "TRANSACTION_PRICE")
    public BigDecimal getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(BigDecimal transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    @Column(name = "TRANSACTION_AMOUNT")
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Column(name = "SHOW_TRANSACTION_TIME")
    public Date getShowTransactionTime() {
        return showTransactionTime;
    }

    public void setShowTransactionTime(Date showTransactionTime) {
        this.showTransactionTime = showTransactionTime;
    }
}
