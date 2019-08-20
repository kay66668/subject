package org.java.service;

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

    int findCount(String username);


}
