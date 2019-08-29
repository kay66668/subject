package org.java.dao;

import org.java.entity.TRole;

public interface TRoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}