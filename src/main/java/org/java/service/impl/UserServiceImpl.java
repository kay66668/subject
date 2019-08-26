package org.java.service.impl;

import org.java.dao.PostMapper;
import org.java.dao.UserMapper;
import org.java.entity.Post;
import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<User> findAll(Integer page,Integer rows,String username) {
        int start=(page-1)*rows;
        return userMapper.findAll(start,rows,username);
    }

    @Override
    public List<User> findAll2(Integer page, Integer rows, String showname) {
        int start=(page-1)*rows;
        return userMapper.findAll2(start,rows,showname);
    }

    @Override
    public int findCount(String username) {

        return userMapper.findCount(username);
    }

    @Override
    public int findCount2(String showname) {
        return userMapper.findCount2(showname);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User selectUser(Integer id) {
        return userMapper.selectUser(id);
    }

    @Transactional
    @Override
    public void delUser(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }
}
