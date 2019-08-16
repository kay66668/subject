package org.java.entity;

import java.util.Date;

public class Transfer {
    private Integer historyid;

    private Date applyfortime;

    private Integer userid;

    private Integer olddepartment;

    private String oldposition;

    private Integer newdepartment;

    private String newposition;

    private Date bouncetime;

    public Integer getHistoryid() {
        return historyid;
    }

    public void setHistoryid(Integer historyid) {
        this.historyid = historyid;
    }

    public Date getApplyfortime() {
        return applyfortime;
    }

    public void setApplyfortime(Date applyfortime) {
        this.applyfortime = applyfortime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOlddepartment() {
        return olddepartment;
    }

    public void setOlddepartment(Integer olddepartment) {
        this.olddepartment = olddepartment;
    }

    public String getOldposition() {
        return oldposition;
    }

    public void setOldposition(String oldposition) {
        this.oldposition = oldposition == null ? null : oldposition.trim();
    }

    public Integer getNewdepartment() {
        return newdepartment;
    }

    public void setNewdepartment(Integer newdepartment) {
        this.newdepartment = newdepartment;
    }

    public String getNewposition() {
        return newposition;
    }

    public void setNewposition(String newposition) {
        this.newposition = newposition == null ? null : newposition.trim();
    }

    public Date getBouncetime() {
        return bouncetime;
    }

    public void setBouncetime(Date bouncetime) {
        this.bouncetime = bouncetime;
    }
}