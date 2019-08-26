package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    public List<Department> getList1(@Param("start") int start, @Param("rows") int rows, @Param("name") String name, @Param("leader") String leader);

    public int getCount1(@Param("name") String name, @Param("leader") String leader);

}