package org.java.util;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserinfoMessage {
    private Integer userid;

    private Integer age;

    private String gender;

    private String showname;

    private String postbox;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bir;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ed;

    @Override
    public String toString() {
        return "UserinfoMessage{" +
                "userid=" + userid +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", showname='" + showname + '\'' +
                ", postbox='" + postbox + '\'' +
                ", bir=" + bir +
                ", address='" + address + '\'' +
                ", ed=" + ed +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEd() {
        return ed;
    }

    public void setEd(Date ed) {
        this.ed = ed;
    }
}
