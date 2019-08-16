package org.java.service.impl;

import org.java.dao.UserMapper;
import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:严辉
 * @Date: 2019/8/16 15:57
 * @Description
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUser(String username, String pwd) {
        List<User> list=userMapper.findUser(username, pwd);
        if(list.isEmpty()){
            return  null;
        }else {
            return list.get(0);
        }
    }
}
