package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Userinfo;

@Mapper
public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);
}