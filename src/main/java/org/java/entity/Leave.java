package org.java.entity;

import java.util.Date;

public class Leave {
    private Integer id;

    private Integer userid;

    private Integer leavetype;

    private Date applyfortime;

    private Date starttime;

    private Date endtime;

    private String reason;

    private Integer day;

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

    public Integer getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(Integer leavetype) {
        this.leavetype = leavetype;
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
}