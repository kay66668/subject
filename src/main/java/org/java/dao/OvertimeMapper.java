package org.java.dao;

import org.java.entity.Overtime;

public interface OvertimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Overtime record);

    int insertSelective(Overtime record);

    Overtime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Overtime record);

    int updateByPrimaryKey(Overtime record);
}