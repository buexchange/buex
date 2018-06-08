package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 场外交易资产Model
 */
@Table(scheme = "BIT_USERMONEY")
public class BitUserMoney {

    private Long id;

    private Long userid;

    private String assetcode;

    private BigDecimal assetamt;

    private BigDecimal freezeamt;

    private BigDecimal usableamt;

    private Date updatetime;

    private Date createtime;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USERID")
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Column(name = "ASSETCODE")
    public String getAssetcode() {
        return assetcode;
    }

    public void setAssetcode(String assetcode) {
        this.assetcode = assetcode;
    }

    @Column(name = "ASSETAMT")
    public BigDecimal getAssetamt() {
        return assetamt;
    }

    public void setAssetamt(BigDecimal assetamt) {
        this.assetamt = assetamt;
    }

    @Column(name = "FREEZEAMT")
    public BigDecimal getFreezeamt() {
        return freezeamt;
    }

    public void setFreezeamt(BigDecimal freezeamt) {
        this.freezeamt = freezeamt;
    }

    @Column(name = "USABLEAMT")
    public BigDecimal getUsableamt() {
        return usableamt;
    }

    public void setUsableamt(BigDecimal usableamt) {
        this.usableamt = usableamt;
    }

    @Column(name = "UPDATETIME")
    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Column(name = "CREATETIME")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
