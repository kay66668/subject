package org.java.service.impl;

import org.java.dao.PostMapper;
import org.java.entity.Post;
import org.java.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper mapper;

    @Override
    public void add(Post post){
        mapper.insert(post);
    }

    @Override
    public void update(Post post){
        mapper.updateByPrimaryKey(post);
    }

    @Override
    public void del(Integer id){
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Post> getList2(int page,int rows,String postname){
       int start = (page-1)*rows;

       return mapper.getList2(start,rows,postname);
    }

    @Override
    public int getCount2(String postname) {
        return mapper.getCount2(postname);
    }
}
