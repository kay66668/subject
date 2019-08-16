package org.java.entity;

public class Usercar {
    private Integer id;

    private Integer userid;

    private String carname;

    private String carport;

    private String ln;

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

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname == null ? null : carname.trim();
    }

    public String getCarport() {
        return carport;
    }

    public void setCarport(String carport) {
        this.carport = carport == null ? null : carport.trim();
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln == null ? null : ln.trim();
    }
}