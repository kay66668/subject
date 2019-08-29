package org.java.entity;

import java.util.Date;

public class TMeetingroom extends TMeetingroomKey {
    private String meetroomplace;

    private String capacity;

    private Date createtime;

    private Integer status;

    public String getMeetroomplace() {
        return meetroomplace;
    }

    public void setMeetroomplace(String meetroomplace) {
        this.meetroomplace = meetroomplace == null ? null : meetroomplace.trim();
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}