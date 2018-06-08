package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@Table(scheme = "EX_CUSTOMER_ASSET")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class CustomerAsset extends BaseModel{

    private Long id;
    private Long userId;
    private Long assetId;
    private String assetCode;
    private BigDecimal assetAmt;
    private BigDecimal freezeAmt;
    private BigDecimal usableAmt;
    private BigDecimal borrowAmt;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name="ASSET_ID")
    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    @Column(name="ASSET_CODE")
    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    @Column(name="ASSET_AMT")
    public BigDecimal getAssetAmt() {
        return assetAmt;
    }

    public void setAssetAmt(BigDecimal assetAmt) {
        this.assetAmt = assetAmt;
    }

    @Column(name="FREEZE_AMT")
    public BigDecimal getFreezeAmt() {
        return freezeAmt;
    }

    public void setFreezeAmt(BigDecimal freezeAmt) {
        this.freezeAmt = freezeAmt;
    }

    @Column(name="USABLE_AMT")
    public BigDecimal getUsableAmt() {
        return usableAmt;
    }

    public void setUsableAmt(BigDecimal usableAmt) {
        this.usableAmt = usableAmt;
    }

    @Column(name="BORROW_AMT")
    public BigDecimal getBorrowAmt() {
        return borrowAmt;
    }

    public void setBorrowAmt(BigDecimal borrowAmt) {
        this.borrowAmt = borrowAmt;
    }
}
