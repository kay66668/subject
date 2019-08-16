package org.java.entity;

import java.util.Date;

public class Evection {
    private Integer id;

    private Integer userid;

    private Date applyfortime;

    private Date starttime;

    private Date endtime;

    private String reason;

    private Integer day;

    private String sa;

    private String ba;

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

    public Date getApplyfortime() {
        return applyfortime;
    }

    public void setApplyfortime(Date applyfortime) {
        this.applyfortime = applyfortime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa == null ? null : sa.trim();
    }

    public String getBa() {
        return ba;
    }

    public void setBa(String ba) {
        this.ba = ba == null ? null : ba.trim();
    }
}