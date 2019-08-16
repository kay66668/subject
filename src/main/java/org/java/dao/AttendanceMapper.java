package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Attendance;

@Mapper
public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}