package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;

import java.math.BigDecimal;
import java.util.Date;

public class DepositOrder {

    private Long id;
    private Long userid;
    private String address;
    private String assetcode;
    private BigDecimal assetamt;
    private BigDecimal realamt;
    private String results;
    private String approvestatus;
    private Date createtime;
    private String txhash; //交易HASH
    private String ordertime;//订单时间

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USERID")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "ASSETCODE")
    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    @Column(name = "ASSETAMT")
    public BigDecimal getAssetamt() {
        return assetamt;
    }

    public void setAssetamt(BigDecimal assetamt) {
        this.assetamt = assetamt;
    }

    @Column(name = "REALAMT")
    public BigDecimal getRealamt() {
        return realamt;
    }

    public void setRealamt(BigDecimal realamt) {
        this.realamt = realamt;
    }

    @Column(name = "RESULTS")
    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Column(name = "APPROVESTATUS")
    public String getApprovestatus() {
        return approvestatus;
    }

    public void setApprovestatus(String approvestatus) {
        this.approvestatus = approvestatus;
    }

    @Column(name = "CREATETIME")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column(name = "TXHASH")
    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }
}
