package org.java.util;

/**
 * @Author:严辉
 * @Date: 2019/8/19 14:10
 * @Description
 */

public class UserMessage {

    private Integer id;

    private String username;

    private String showname;

    private String pwd;

    private String postname;

    private String NAME;

    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", showname='" + showname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", postname='" + postname + '\'' +
                ", NAME='" + NAME + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
