package org.java.dao;

import org.java.entity.Evection;

public interface EvectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evection record);

    int insertSelective(Evection record);

    Evection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evection record);

    int updateByPrimaryKey(Evection record);
}