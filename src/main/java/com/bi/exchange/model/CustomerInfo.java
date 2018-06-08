package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Table(scheme = "EX_CUSTOMER_INFO")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class CustomerInfo extends BaseModel {
    private Long id ;
    private String mobile;
    private String email ;
    private Date birthday ;
    private String userName ;
    private String realName ;
    private String customerType;
    private String payPassword ;
    private String password ;
    private String isAuth ;
    private String authType ;
    private String idcard ;
    private String googleIdentifier ;
    private String activated ;
    private String customerLevel;
    private String validationMobile ;
    private String validationEmail ;
    private String validationGoogle ;
    private Date registerTime ;
    private String loginPwdStrong;
    private String payPwdStrong;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="MOBILE")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name="EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="BIRTHDAY")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name="USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="REAL_NAME")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Column(name="CUSTOMER_TYPE")
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Column(name="PAY_PASSWORD")
    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="IS_AUTH")
    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    @Column(name="AUTH_TYPE")
    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Column(name="IDCARD")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Column(name="GOOGLE_IDENTIFIER")
    public String getGoogleIdentifier() {
        return googleIdentifier;
    }

    public void setGoogleIdentifier(String googleIdentifier) {
        this.googleIdentifier = googleIdentifier;
    }

    @Column(name="ACTIVATED")
    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    @Column(name="CUSTOMER_LEVEL")
    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    @Column(name="VALIDATION_MOBILE")
    public String getValidationMobile() {
        return validationMobile;
    }

    public void setValidationMobile(String validationMobile) {
        this.validationMobile = validationMobile;
    }

    @Column(name="VALIDATION_EMAIL")
    public String getValidationEmail() {
        return validationEmail;
    }

    public void setValidationEmail(String validationEmail) {
        this.validationEmail = validationEmail;
    }

    @Column(name="VALIDATION_GOOGLE")
    public String getValidationGoogle() {
        return validationGoogle;
    }

    public void setValidationGoogle(String validationGoogle) {
        this.validationGoogle = validationGoogle;
    }

    @Column(name="REGISTER_TIME")
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Column(name = "LOGINPWDSTRONG")
    public String getLoginPwdStrong() {
        return loginPwdStrong;
    }

    public void setLoginPwdStrong(String loginPwdStrong) {
        this.loginPwdStrong = loginPwdStrong;
    }

    @Column(name = "PAYPWDSTRONG")
    public String getPayPwdStrong() {
        return payPwdStrong;
    }

    public void setPayPwdStrong(String payPwdStong) {
        this.payPwdStrong = payPwdStong;
    }
}
