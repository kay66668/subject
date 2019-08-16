package org.java.dao;

import org.java.entity.Meetinginfo;

public interface MeetinginfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meetinginfo record);

    int insertSelective(Meetinginfo record);

    Meetinginfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meetinginfo record);

    int updateByPrimaryKey(Meetinginfo record);
}