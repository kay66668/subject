package org.java.dao;

import org.java.entity.TPermission;

public interface TPermissionMapper {
    int deleteByPrimaryKey(Integer permissionid);

    int insert(TPermission record);

    int insertSelective(TPermission record);

    TPermission selectByPrimaryKey(Integer permissionid);

    int updateByPrimaryKeySelective(TPermission record);

    int updateByPrimaryKey(TPermission record);
}