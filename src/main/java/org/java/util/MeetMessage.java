package org.java.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MeetMessage {

    private Integer id;

    private String createBy;

    private String title;

    private String descr;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    private String meetRoomId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getMeetRoomId() {
        return meetRoomId;
    }

    public void setMeetRoomId(String meetRoomId) {
        this.meetRoomId = meetRoomId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MeetMessage{" +
                "id=" + id +
                ", createBy='" + createBy + '\'' +
                ", title='" + title + '\'' +
                ", descr='" + descr + '\'' +
                ", startTime=" + startTime +
                ", meetRoomId='" + meetRoomId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
