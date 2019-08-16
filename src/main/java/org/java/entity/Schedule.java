package org.java.entity;

import java.util.Date;

public class Schedule {
    private Integer id;

    private String title;

    private String meetinglocation;

    private Integer meetingtype;

    private Date starttime;

    private Date endtime;

    private String content;

    private Integer creator;

    private Integer createdepartment;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMeetinglocation() {
        return meetinglocation;
    }

    public void setMeetinglocation(String meetinglocation) {
        this.meetinglocation = meetinglocation == null ? null : meetinglocation.trim();
    }

    public Integer getMeetingtype() {
        return meetingtype;
    }

    public void setMeetingtype(Integer meetingtype) {
        this.meetingtype = meetingtype;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getCreatedepartment() {
        return createdepartment;
    }

    public void setCreatedepartment(Integer createdepartment) {
        this.createdepartment = createdepartment;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}