package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Worktime;

@Mapper
public interface WorktimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Worktime record);

    int insertSelective(Worktime record);

    Worktime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Worktime record);

    int updateByPrimaryKey(Worktime record);
}