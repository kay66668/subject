package org.java.service.impl;

import org.java.dao.UserinfoMapper;
import org.java.entity.Userinfo;
import org.java.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    private UserinfoMapper mapper;


    @Override
    @Transactional
    public void add(Userinfo userinfo) {
        mapper.insert(userinfo);
    }

    @Override
    @Transactional
    public void del(Integer userid){
        mapper.deleteByPrimaryKey(userid);
    }

    @Override
    @Transactional
    public void update(Userinfo userinfo){
        mapper.updateByPrimaryKey(userinfo);
    }

    @Override
    public List<Userinfo> getList(int page,int rows,String tel,String postbox){

        int start = (page-1)*rows;

        return mapper.getList(start,rows,tel,postbox);

    }

    @Override
    public int getCount(String tel,String postbox){
        return mapper.getCount(tel,postbox);
    }

}
