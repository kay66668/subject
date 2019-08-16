package org.java.dao;

import org.java.entity.Userinfo;

public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);
}