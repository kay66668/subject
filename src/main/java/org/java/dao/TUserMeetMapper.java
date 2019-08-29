package org.java.dao;

import org.java.entity.TUserMeet;

public interface TUserMeetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TUserMeet record);

    int insertSelective(TUserMeet record);

    TUserMeet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TUserMeet record);

    int updateByPrimaryKey(TUserMeet record);
}