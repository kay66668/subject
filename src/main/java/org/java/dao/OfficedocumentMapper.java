package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Officedocument;

@Mapper
public interface OfficedocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Officedocument record);

    int insertSelective(Officedocument record);

    Officedocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Officedocument record);

    int updateByPrimaryKey(Officedocument record);
}