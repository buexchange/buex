package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@Table(scheme = "EX_User_Asset_Record")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class UserAssetRecord extends BaseModel{

    private Long id;
    private Long userId;
    private Long settleAssetId;
    private String assetCode;
    private BigDecimal netAssetAmt;
    private BigDecimal lastAssetAmt;
    private String operateType;
    private BigDecimal operatorAmt;
    private Long depositOrderId;
    private Long drawOrderId;
    private BigDecimal walletFee;
    private String recordTime;


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

    @Column(name = "SETTLE_ASSET_ID")
    public Long getSettleAssetId() {
        return settleAssetId;
    }

    public void setSettleAssetId(Long settleAssetId) {
        this.settleAssetId = settleAssetId;
    }

    @Column(name = "ASSET_CODE")
    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    @Column(name = "NET_ASSET_AMT")
    public BigDecimal getNetAssetAmt() {
        return netAssetAmt;
    }

    public void setNetAssetAmt(BigDecimal netAssetAmt) {
        this.netAssetAmt = netAssetAmt;
    }

    @Column(name = "LAST_ASSET_AMT")
    public BigDecimal getLastAssetAmt() {
        return lastAssetAmt;
    }

    public void setLastAssetAmt(BigDecimal lastAssetAmt) {
        this.lastAssetAmt = lastAssetAmt;
    }

    @Column(name = "OPERATE_TYPE")
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    @Column(name = "OPERATOR_AMT")
    public BigDecimal getOperatorAmt() {
        return operatorAmt;
    }

    public void setOperatorAmt(BigDecimal operatorAmt) {
        this.operatorAmt = operatorAmt;
    }

    @Column(name = "DEPOSIT_ORDER_ID")
    public Long getDepositOrderId() {
        return depositOrderId;
    }

    public void setDepositOrderId(Long depositOrderId) {
        this.depositOrderId = depositOrderId;
    }

    @Column(name = "DRAW_ORDER_ID")
    public Long getDrawOrderId() {
        return drawOrderId;
    }

    public void setDrawOrderId(Long drawOrderId) {
        this.drawOrderId = drawOrderId;
    }

    @Column(name = "WALLET_FEE")
    public BigDecimal getWalletFee() {
        return walletFee;
    }

    public void setWalletFee(BigDecimal walletFee) {
        this.walletFee = walletFee;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }
}
