package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;

import java.math.BigDecimal;
import java.util.Date;

@Table(scheme = "BIT_BTCBLOCKTX")
public class BtcBlockTx {

    private Long id;

    private String txhash;

    private Long depositeid;

    private Long txtime;

    private String blockhash;

    private BigDecimal valueout;

    private BigDecimal valuein;

    private String outaddress;

    private String inaddress;

    private Date createtime;

    private Long confirmations;

    private String isconfirmed;

    private String isscan;

    private String platform;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TXHASH")
    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    @Column(name = "DEPOSITEID")
    public Long getDepositeid() {
        return depositeid;
    }

    public void setDepositeid(Long depositeid) {
        this.depositeid = depositeid;
    }

    @Column(name = "TXTIME")
    public Long getTxtime() {
        return txtime;
    }

    public void setTxtime(Long txtime) {
        this.txtime = txtime;
    }

    @Column(name = "BLOCKHASH")
    public String getBlockhash() {
        return blockhash;
    }

    public void setBlockhash(String blockhash) {
        this.blockhash = blockhash;
    }

    @Column(name = "VALUEOUT")
    public BigDecimal getValueout() {
        return valueout;
    }

    public void setValueout(BigDecimal valueout) {
        this.valueout = valueout;
    }

    @Column(name = "VALUEIN")
    public BigDecimal getValuein() {
        return valuein;
    }

    public void setValuein(BigDecimal valuein) {
        this.valuein = valuein;
    }

    @Column(name = "OUTADDRESS")
    public String getOutaddress() {
        return outaddress;
    }

    public void setOutaddress(String outaddress) {
        this.outaddress = outaddress;
    }

    @Column(name = "INADDRESS")
    public String getInaddress() {
        return inaddress;
    }

    public void setInaddress(String inaddress) {
        this.inaddress = inaddress;
    }

    @Column(name = "CREATETIME")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column(name = "CONFIRMATIONS")
    public Long getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Long confirmations) {
        this.confirmations = confirmations;
    }

    @Column(name = "ISCONFIRMED")
    public String getIsconfirmed() {
        return isconfirmed;
    }

    public void setIsconfirmed(String isconfirmed) {
        this.isconfirmed = isconfirmed;
    }

    @Column(name = "ISSCAN")
    public String getIsscan() {
        return isscan;
    }

    public void setIsscan(String isscan) {
        this.isscan = isscan;
    }

    @Column(name = "PLATFORM")
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}