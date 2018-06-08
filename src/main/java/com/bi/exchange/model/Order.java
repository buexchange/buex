package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;

import java.math.BigDecimal;
import java.util.List;

public class Order extends BaseModel{

    private Long id;
    private Long userid;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal freezeAmt;
    private BigDecimal remainFreezeAmt;
    private Long orderTime;
    private String orderStatus;
    private String tradeType;
    private BigDecimal avgPrice;
    private BigDecimal realAmount;
    private String isJumpQueue;
    private List transList;
    private String spotOrderTime;
    private BigDecimal surplusAmount;
    private String status;
    private String priceStr;


    private Integer makeMarket = 0;

    private BigDecimal stopLessTriggerPrice;

    private BigDecimal stopSuccessTriggerPrice;

    private BigDecimal stopLessOrderPrice;

    private BigDecimal stopSuccessOrderPrice;

    private BigDecimal triggerPrice;

    private int currentPage;

    private int pageTotal;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }


    public BigDecimal getStopLessTriggerPrice() {
        return stopLessTriggerPrice;
    }

    public void setStopLessTriggerPrice(BigDecimal stopLessTriggerPrice) {
        this.stopLessTriggerPrice = stopLessTriggerPrice;
    }

    public BigDecimal getStopSuccessTriggerPrice() {
        return stopSuccessTriggerPrice;
    }

    public void setStopSuccessTriggerPrice(BigDecimal stopSuccessTriggerPrice) {
        this.stopSuccessTriggerPrice = stopSuccessTriggerPrice;
    }

    public BigDecimal getStopLessOrderPrice() {
        return stopLessOrderPrice;
    }

    public void setStopLessOrderPrice(BigDecimal stopLessOrderPrice) {
        this.stopLessOrderPrice = stopLessOrderPrice;
    }

    public BigDecimal getStopSuccessOrderPrice() {
        return stopSuccessOrderPrice;
    }

    public void setStopSuccessOrderPrice(BigDecimal stopSuccessOrderPrice) {
        this.stopSuccessOrderPrice = stopSuccessOrderPrice;
    }

    public BigDecimal getTriggerPrice() {
        return triggerPrice;
    }

    public void setTriggerPrice(BigDecimal triggerPrice) {
        this.triggerPrice = triggerPrice;
    }

//    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

//    @Column(name = "FREEZE_AMT")
    public BigDecimal getFreezeAmt() {
        return freezeAmt;
    }

    public void setFreezeAmt(BigDecimal freezeAmt) {
        this.freezeAmt = freezeAmt;
    }

//    @Column(name = "REMAIN_FREEZE_AMT")
    public BigDecimal getRemainFreezeAmt() {
        return remainFreezeAmt;
    }

    public void setRemainFreezeAmt(BigDecimal remainFreezeAmt) {
        this.remainFreezeAmt = remainFreezeAmt;
    }


//    @Column(name = "TRADE_TYPE")
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

//    @Column(name = "AVG_PRICE")
    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

//    @Column(name = "REAL_AMOUNT")
    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

//    @Column(name = "MAKE_MARKET")
    public Integer getMakeMarket() {
        return makeMarket;
    }

    public void setMakeMarket(Integer makeMarket) {
        this.makeMarket = makeMarket;
    }

    public List getTransList() {
        return transList;
    }

    public void setTransList(List transList) {
        this.transList = transList;
    }

    public String getSpotOrderTime() {
        return spotOrderTime;
    }

    public void setSpotOrderTime(String spotOrderTime) {
        this.spotOrderTime = spotOrderTime;
    }

    public BigDecimal getSurplusAmount() {
        return surplusAmount;
    }

    public void setSurplusAmount(BigDecimal surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getIsJumpQueue() {
        return isJumpQueue;
    }

    public void setIsJumpQueue(String isJumpQueue) {
        this.isJumpQueue = isJumpQueue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriceStr() {
        return priceStr;
    }

    public void setPriceStr(String priceStr) {
        this.priceStr = priceStr;
    }
}
