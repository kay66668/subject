package org.java.entity;

public class TMeetingroomKey {
    private Integer id;

    private String meetroomname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeetroomname() {
        return meetroomname;
    }

    public void setMeetroomname(String meetroomname) {
        this.meetroomname = meetroomname == null ? null : meetroomname.trim();
    }
}