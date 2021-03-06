package org.java.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Userinfo {
    private Integer userid;

    private Integer age;

    private String gender;

    private String postbox;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bir;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ed;

    @Override
    public String toString() {
        return "Userinfo{" +
                "userid=" + userid +
                ", age=" + age +
                ", gender='" + gender + '\'' +
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
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPostbox() {
        return postbox;
    }

    public void setPostbox(String postbox) {
        this.postbox = postbox == null ? null : postbox.trim();
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
        this.address = address == null ? null : address.trim();
    }

    public Date getEd() {
        return ed;
    }

    public void setEd(Date ed) {
        this.ed = ed;
    }
}