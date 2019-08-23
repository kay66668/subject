package org.java.service;

import org.java.entity.Post;

import java.util.List;

public interface PostService {
    public void add(Post post);

    public void update(Post post);

    public void del(Integer id);

    public List<Post> getList2();

}
