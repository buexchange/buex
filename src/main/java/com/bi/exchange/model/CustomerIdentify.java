package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import java.util.Date;

@Table(scheme = "BIT_USERIDENTIFY")
public class CustomerIdentify {

    Long id;
    Long userId;
    String idPhoneFront;
    String idPhoneBack;
    String idPhotoHand;
    String credentialsType;
    String credentialsCode;
    String auditStatus;
    String auditReason;
    String authType;
    Date birthday;
    String realName;
    String country;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USERID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "IDPHOTOFRONT")
    public String getIdPhoneFront() {
        return idPhoneFront;
    }

    public void setIdPhoneFront(String idPhoneFront) {
        this.idPhoneFront = idPhoneFront;
    }

    @Column(name = "IDPHOTOBACK")
    public String getIdPhoneBack() {
        return idPhoneBack;
    }

    public void setIdPhoneBack(String idPhoneBack) {
        this.idPhoneBack = idPhoneBack;
    }

    @Column(name = "IDPHOTOHAND")
    public String getIdPhotoHand() {
        return idPhotoHand;
    }

    public void setIdPhotoHand(String idPhotoHand) {
        this.idPhotoHand = idPhotoHand;
    }

    @Column(name = "CREDENTIALSTYPE")
    public String getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(String credentialsType) {
        this.credentialsType = credentialsType;
    }

    @Column(name = "CREDENTIALSCODE")
    public String getCredentialsCode() {
        return credentialsCode;
    }

    public void setCredentialsCode(String credentialsCode) {
        this.credentialsCode = credentialsCode;
    }

    @Column(name = "AUDITSTATUS")
    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    @Column(name = "AUDITREASON")
    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }

    @Column(name = "AUTHTYPE")
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Column(name = "BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "REALNAME")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
