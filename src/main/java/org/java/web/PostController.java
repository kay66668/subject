package org.java.web;


import org.java.entity.Post;
import org.java.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("/addPost")
    @ResponseBody
    public void add(Post post){
        postService.add(post);
    }

    @RequestMapping("/updatePost")
    @ResponseBody
    public void update(Post post){
        postService.update(post);
    }

    @RequestMapping("/delPost")
    @ResponseBody
    public void del(Integer id){
        postService.del(id);
    }

    @RequestMapping("getList2")
    @ResponseBody
    public Map getList(Integer page, Integer limit, String postname){
        Map map = new HashMap();

        List<Post> list = postService.getList2(page,limit,postname);
        int count = postService.getCount2(postname);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;

    }
}
