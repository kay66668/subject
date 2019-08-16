package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Changing;

@Mapper
public interface ChangingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Changing record);

    int insertSelective(Changing record);

    Changing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Changing record);

    int updateByPrimaryKey(Changing record);
}