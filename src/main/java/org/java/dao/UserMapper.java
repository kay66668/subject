package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.User;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll(@Param("start") Integer start,@Param("rows") Integer rows,@Param("username") String username);

    List<User> findAll2(@Param("start") Integer start,@Param("rows") Integer rows,@Param("showname") String showname);

    int findCount(@Param("username") String username);

    int findCount2(@Param("showname") String showname);

    void addUser(User user);

    void updateUser(User user);

    User selectUser(Integer id);

    void delUser(Integer id);

    List<User> findUser(@Param("username") String username,@Param("pwd") String pwd);

    List<User> selectByUser(User user);
}