package com.bi.exchange.model;

import com.bi.exchange.framework.model.BaseModel;
import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(scheme = "EX_CUSTOMER_SECURITY_POLICY")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class CustomerSecurityPolicy extends BaseModel{

    private Long id;
    private Long userId;
    private String securityId;
    private String showText;
    private String validationMode;
    private String isEnabled;
    private String isRecent;

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

    @Column(name = "SECURITY_ID")
    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    @Column(name = "SHOW_TEXT")
    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    @Column(name = "VALIDATION_MODE")
    public String getValidationMode() {
        return validationMode;
    }

    public void setValidationMode(String validationMode) {
        this.validationMode = validationMode;
    }

    @Column(name = "IS_ENABLED")
    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Column(name = "IS_RECENT")
    public String getIsRecent() {
        return isRecent;
    }

    public void setIsRecent(String isRecent) {
        this.isRecent = isRecent;
    }
}
