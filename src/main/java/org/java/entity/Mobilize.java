package org.java.entity;

import java.util.Date;

public class Mobilize {
    private Integer id;

    private Integer userid;

    private Integer olddepartment;

    private String oldposition;

    private Integer newdepartment;

    private String newposition;

    private Date bouncetime;

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