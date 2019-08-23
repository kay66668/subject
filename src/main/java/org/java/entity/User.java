package org.java.entity;

public class User {

    private Integer id;

    private String username;

    private String showname;

    private String pwd;

    private Integer post;

    private Integer departmentid;

    private String headpath;

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
        this.username = username == null ? null : username.trim();
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname == null ? null : showname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath == null ? null : headpath.trim();
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", showname='" + showname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", post=" + post +
                ", departmentid=" + departmentid +
                ", headpath='" + headpath + '\'' +
                '}';
    }
}