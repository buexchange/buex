package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(scheme = "EX_WALLET_INFO")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class WalletInfo extends BaseModel{
    private Long id;
    private Long userId;
    private Long digitAssetId;
    private String walletType;
    private String digitAssetAddress;
    private String assetCode;
    private String isDefault;
    private String isCertification;
    private String remark;

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

    @Column(name = "DIGIT_ASSET_ID")
    public Long getDigitAssetId() {
        return digitAssetId;
    }

    public void setDigitAssetId(Long digitAssetId) {
        this.digitAssetId = digitAssetId;
    }

    @Column(name = "WALLET_TYPE")
    public String getWalletType() {
        return walletType;
    }

    public void setWalletType(String walletType) {
        this.walletType = walletType;
    }

    @Column(name = "DIGIT_ASSET_ADDRE")
    public String getDigitAssetAddress() {
        return digitAssetAddress;
    }

    public void setDigitAssetAddress(String digitAssetAddress) {
        this.digitAssetAddress = digitAssetAddress;
    }

    @Column(name = "ASSET_CODE")
    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    @Column(name = "IS_DEFAULT")
    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Column(name = "IS_CERTIFICATIO")
    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification;
    }

    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
