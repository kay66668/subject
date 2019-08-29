package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.TMeet;

import java.util.List;
@Mapper
public interface TMeetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMeet record);

    int insertSelective(TMeet record);

    TMeet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMeet record);

    int updateByPrimaryKey(TMeet record);

    List<TMeet> getMeetList(@Param("start") int start, @Param("rows") int rows,@Param("createBy") String createBy,@Param("title") String title);

    int getCount(@Param("createBy") String createBy,@Param("title") String title);
}