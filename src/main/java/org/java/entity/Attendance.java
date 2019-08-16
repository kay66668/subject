package org.java.entity;

import java.util.Date;

public class Attendance {
    private Integer id;

    private Integer userid;

    private Date signintime;

    private Date signbacktime;

    private String remark;

    private String tab;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getSignintime() {
        return signintime;
    }

    public void setSignintime(Date signintime) {
        this.signintime = signintime;
    }

    public Date getSignbacktime() {
        return signbacktime;
    }

    public void setSignbacktime(Date signbacktime) {
        this.signbacktime = signbacktime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab == null ? null : tab.trim();
    }
}