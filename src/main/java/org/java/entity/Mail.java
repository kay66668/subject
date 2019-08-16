package org.java.entity;

import java.util.Date;

public class Mail {
    private String addresser;

    private String addressee;

    private String title;

    private String content;

    private Date receivingtime;

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser == null ? null : addresser.trim();
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee == null ? null : addressee.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getReceivingtime() {
        return receivingtime;
    }

    public void setReceivingtime(Date receivingtime) {
        this.receivingtime = receivingtime;
    }
}