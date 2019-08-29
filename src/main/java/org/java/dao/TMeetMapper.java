package org.java.dao;

import org.java.entity.TMeet;

public interface TMeetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMeet record);

    int insertSelective(TMeet record);

    TMeet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMeet record);

    int updateByPrimaryKey(TMeet record);
}