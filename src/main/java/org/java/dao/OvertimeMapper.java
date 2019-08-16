package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Overtime;

@Mapper
public interface OvertimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Overtime record);

    int insertSelective(Overtime record);

    Overtime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Overtime record);

    int updateByPrimaryKey(Overtime record);
}