package org.java.dao;

import org.java.entity.Leavetype;

public interface LeavetypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leavetype record);

    int insertSelective(Leavetype record);

    Leavetype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leavetype record);

    int updateByPrimaryKey(Leavetype record);
}