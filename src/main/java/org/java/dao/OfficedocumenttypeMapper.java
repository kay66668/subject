package org.java.dao;

import org.java.entity.Officedocumenttype;

public interface OfficedocumenttypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Officedocumenttype record);

    int insertSelective(Officedocumenttype record);

    Officedocumenttype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Officedocumenttype record);

    int updateByPrimaryKey(Officedocumenttype record);
}