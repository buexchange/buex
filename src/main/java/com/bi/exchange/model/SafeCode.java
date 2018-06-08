package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;

import java.util.Date;

@Table(scheme = "BIT_SAFECODE")
public class SafeCode {
	private Long id;
    private String skey;
    private String svalue;
    private Date expiryTime;
    private Date updateTime;
    private Long userId;
    private String sceneId;
    private Date scanTime;
    private String scanGenKey;
    private String businessType;
    private String openId;



    public SafeCode() {
    }

    public SafeCode(String skey, String svalue, Date expirytime,
                    Date updatetime, Long userid, String sceneid,String businesstype,String scangenkey) {
        super();
        this.skey = skey;
        this.svalue = svalue;
        this.expiryTime = expirytime;
        this.updateTime = updatetime;
        this.userId = userid;
        this.sceneId = sceneid;
        this.businessType = businesstype;
        this.scanGenKey=scangenkey;
    }
    

	@PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "SKEY")
    public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

    @Column(name = "SVALUE")
    public String getSvalue() {
		return svalue;
	}

	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

    @Column(name = "EXPIRYTIME")
    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    @Column(name = "UPDATETIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "USERID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "SCENEID")
    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    @Column(name = "SCANTIME")
    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    @Column(name = "SCANGENKEY")
    public String getScanGenKey() {
        return scanGenKey;
    }

    public void setScanGenKey(String scanGenKey) {
        this.scanGenKey = scanGenKey;
    }

    @Column(name = "BUSINESSTYPE")
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Column(name = "OPENID")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
