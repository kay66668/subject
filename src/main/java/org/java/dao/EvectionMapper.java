package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Evection;

@Mapper
public interface EvectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evection record);

    int insertSelective(Evection record);

    Evection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evection record);

    int updateByPrimaryKey(Evection record);
}