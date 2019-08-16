package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.LeaveOffice;

@Mapper
public interface LeaveOfficeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeaveOffice record);

    int insertSelective(LeaveOffice record);

    LeaveOffice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeaveOffice record);

    int updateByPrimaryKey(LeaveOffice record);
}