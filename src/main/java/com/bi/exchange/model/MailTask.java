package com.bi.exchange.model;

import com.bi.exchange.framework.model.Column;
import com.bi.exchange.framework.model.PrimaryKey;
import com.bi.exchange.framework.model.Table;

import java.util.Date;

@Table(scheme = "STD_MAIL_TASK")
public class MailTask {

    private Long id;
    private String title;
    private String content;
    private String email;
    private String status;
    private Date sendtime;
    private String functionname;
    private Date createtime;

    @PrimaryKey
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "SENDTIME")
    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    @Column(name = "FUNCTIONNAME")
    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname;
    }

    @Column(name = "CREATETIME")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
