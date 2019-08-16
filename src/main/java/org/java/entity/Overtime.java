package org.java.entity;

import java.util.Date;

public class Overtime {
    private Integer id;

    private Integer userid;

    private Date applyfortime;

    private Date starttime;

    private Date endtime;

    private String overtimehours;

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

    public String getOvertimehours() {
        return overtimehours;
    }

    public void setOvertimehours(String overtimehours) {
        this.overtimehours = overtimehours == null ? null : overtimehours.trim();
    }
}