package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.Transfer;
import org.java.entity.Userinfo;
import org.java.util.UserinfoMessage;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    int deleteByPrimaryKey(Integer historyid);

    Transfer selectByPrimaryKey(Integer historyid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    public List<UserinfoMessage> getList(@Param("start") int start, @Param("rows") int rows, @Param("tel") String tel, @Param("postbox") String postbox);

    public int getCount(@Param("tel") String tel,@Param("postbox") String postbox);
}

