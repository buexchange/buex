package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;

import java.util.Date;

@Table(scheme = "BIT_SMSTASK")
public class SmsTask{
    private Long id;
    private Long userId;
    private String msgId;
    private String mobile;
    private String status;
    private String functionName;
    private Date sendTime;
    private String sResult;
    private Long cType;
    private Long way;
    private String msg;
    private Date createTime;


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

    @Column(name = "MSGID")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Column(name = "MOBILE")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "FUNCTIONNAME")
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Column(name = "SENDTIME")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    @Column(name = "SRESULT")
    public String getsResult() {
        return sResult;
    }

    public void setsResult(String sResult) {
        this.sResult = sResult;
    }

    @Column(name = "CTYPE")
    public Long getcType() {
        return cType;
    }

    public void setcType(Long cType) {
        this.cType = cType;
    }

    @Column(name = "WAY")
    public Long getWay() {
        return way;
    }

    public void setWay(Long way) {
        this.way = way;
    }

    @Column(name = "MSG")
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Column(name = "CREATETIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
