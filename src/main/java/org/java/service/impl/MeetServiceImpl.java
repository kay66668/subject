package org.java.service.impl;

import org.java.dao.TMeetMapper;
import org.java.entity.TMeet;
import org.java.service.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeetServiceImpl implements MeetService {
    @Autowired
    private TMeetMapper meetMapper;

    @Override
    public void add(TMeet meet) {
        meetMapper.insert(meet);
    }

    @Override
    public void update(TMeet meet) {
        meetMapper.updateByPrimaryKey(meet);
    }

    @Override
    public void del(Integer id) {
        meetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TMeet> getMeetList(int page, int rows, String createBy, String title) {
        int start = (page-1)*rows;
        return meetMapper.getMeetList(start,rows,createBy,title);
    }

    @Override
    public int getCount(String createBy, String title) {
        return meetMapper.getCount(createBy,title);
    }
}
