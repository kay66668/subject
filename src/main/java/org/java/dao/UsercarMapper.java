package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Usercar;

@Mapper
public interface UsercarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usercar record);

    int insertSelective(Usercar record);

    Usercar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Usercar record);

    int updateByPrimaryKey(Usercar record);
}