package org.java.dao;

import org.java.entity.Usercar;

public interface UsercarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usercar record);

    int insertSelective(Usercar record);

    Usercar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Usercar record);

    int updateByPrimaryKey(Usercar record);
}