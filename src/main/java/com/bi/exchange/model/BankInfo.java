package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(scheme = "EX_BANK_INFO")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class BankInfo extends BaseModel{

    private Long id;
    private Long userId;
    private String bankName;
    private String branchName;
    private String bankAccount;
    private String cardHolderName;
    private String idNumber;
    private String cardHolderMobile;
    private String isDefault;
    private String isAuth;
    private String remark;
    private String bankProvince;
    private String bankCity;

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

    @Column(name = "BANK_ACCOUNT")
    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Column(name = "CARD_HOLDER_NAME")
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @Column(name = "ID_NUMBER")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Column(name = "CARD_HOLDER_MOBILE")
    public String getCardHolderMobile() {
        return cardHolderMobile;
    }

    public void setCardHolderMobile(String cardHolderMobile) {
        this.cardHolderMobile = cardHolderMobile;
    }

    @Column(name = "IS_DEFAULT")
    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Column(name = "IS_AUTH")
    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
