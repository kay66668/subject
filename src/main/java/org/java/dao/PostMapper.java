package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.java.entity.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    public List<Post> getList2();
}