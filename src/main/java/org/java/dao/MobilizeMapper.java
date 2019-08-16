package org.java.dao;

import org.java.entity.Mobilize;

public interface MobilizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mobilize record);

    int insertSelective(Mobilize record);

    Mobilize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mobilize record);

    int updateByPrimaryKey(Mobilize record);
}