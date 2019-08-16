package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Meetinginfo;

@Mapper
public interface MeetinginfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Meetinginfo record);

    int insertSelective(Meetinginfo record);

    Meetinginfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Meetinginfo record);

    int updateByPrimaryKey(Meetinginfo record);
}