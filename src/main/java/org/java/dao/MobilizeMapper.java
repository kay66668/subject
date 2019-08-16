package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Mobilize;

@Mapper
public interface MobilizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mobilize record);

    int insertSelective(Mobilize record);

    Mobilize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mobilize record);

    int updateByPrimaryKey(Mobilize record);
}