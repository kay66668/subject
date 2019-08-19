package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author:严辉
 * @Date: 2019/8/19 10:48
 * @Description
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value={"/load","/load/{page}"})
    public String findAll(Model model, @PathVariable(value = "page",required = false) Integer page){

        if(page==null){
            page=1;
        }
        int rows=3;
        int count=userService.findCount();
        int maxPage=count%rows==0?count/rows:count/rows+1;
        List<User> list=userService.findAll(page,rows);
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute("count",count);
        model.addAttribute("maxPage",maxPage);
        return "/user2";
    }
}
