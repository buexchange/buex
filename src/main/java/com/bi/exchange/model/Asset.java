package com.bi.exchange.model;

import com.bi.exchange.framework.model.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(scheme = "EX_ASSET")
@JsonIgnoreProperties({"deleted", "createTime", "createUser", "updateTime", "updateUser"})
public class Asset extends BaseModel{

    private Long id;
    private Long parentId;
    private String assetName;
    private String assetCode;
    private String assetType;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "PARENT_ID")
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "ASSET_NAME")
    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @Column(name = "ASSET_CODE")
    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    @Column(name = "ASSET_TYPE")
    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
}
