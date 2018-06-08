package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

@Table(scheme = "EX_DRAW_ORDER")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class DrawOrder extends BaseModel {
    private Long id;
    private Long userId;
    private Long assetId;
    private String assetCode;
    private BigDecimal amount;
    private String walletAddress;
    private BigDecimal walletFee;
    private String bankName;
    private String branchName;
    private String bankProvince;
    private String bankCity;
    private String status;
    private String approveStatus;
    private String failureReason;
    private String mark;
    private String fstApprove;
    private String secApprove;
    private String trdApprove;
    private String forApprove;
    private String fifApprove;
    private String orderTime;   //订单时间

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

    @Column(name = "ASSET_ID")
    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    @Column(name = "ASSET_CODE")
    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "WALLET_ADDRESS")
    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Column(name = "WALLET_FEE")
    public BigDecimal getWalletFee() {
        return walletFee;
    }

    public void setWalletFee(BigDecimal walletFee) {
        this.walletFee = walletFee;
    }

    @Column(name = "BANK_NAME")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "BRANCH_NAME")
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Column(name = "BANK_PROVINCE")
    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    @Column(name = "BANK_CITY")
    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "APPROVE_STATUS")
    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    @Column(name = "FAILURE_REASON")
    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @Column(name = "MARK")
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Column(name = "FST_APPROVE")
    public String getFstApprove() {
        return fstApprove;
    }

    public void setFstApprove(String fstApprove) {
        this.fstApprove = fstApprove;
    }

    @Column(name = "SEC_APPROVE")
    public String getSecApprove() {
        return secApprove;
    }

    public void setSecApprove(String secApprove) {
        this.secApprove = secApprove;
    }

    @Column(name = "TRD_APPROVE")
    public String getTrdApprove() {
        return trdApprove;
    }

    public void setTrdApprove(String trdApprove) {
        this.trdApprove = trdApprove;
    }

    @Column(name = "FOR_APPROVE")
    public String getForApprove() {
        return forApprove;
    }

    public void setForApprove(String forApprove) {
        this.forApprove = forApprove;
    }

    @Column(name = "FIF_APPROVE")
    public String getFifApprove() {
        return fifApprove;
    }

    public void setFifApprove(String fifApprove) {
        this.fifApprove = fifApprove;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
