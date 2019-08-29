package org.java.service;

import org.java.entity.Post;
import org.java.entity.User;

import java.util.List;

/**
 * @Author:严辉
 * @Date: 2019/8/16 15:52
 * @Description
 */


public interface UserService {

    User findUser(String username,String pwd);

    List<User> findAll(Integer page,Integer rows,String username);

    List<User> findAll2(Integer page,Integer rows,String showname);

    int findCount(String username);

    int findCount2(String showname);

    void addUser(User user);

    void updateUser(User user);

    User selectUser(Integer id);

    void delUser(Integer id);

    List<User> selectByUser(User user);

    User selectByPrimaryKey(Integer id);




}
