package org.java.entity;

import java.util.Date;

public class LeaveOffice {
    private Integer id;

    private Integer userid;

    private Date applyfortime;

    private Date hd;

    private Date td;

    private Integer departmentid;

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

    public Date getHd() {
        return hd;
    }

    public void setHd(Date hd) {
        this.hd = hd;
    }

    public Date getTd() {
        return td;
    }

    public void setTd(Date td) {
        this.td = td;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }
}