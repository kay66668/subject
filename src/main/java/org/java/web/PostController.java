package org.java.web;

import org.java.entity.Post;
import org.java.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/getList2")
    @ResponseBody
    public List<Post> getList2(Model model){
        List<Post> list = postService.getList2();

        model.addAttribute("list",list);

        return list;
    }
}
