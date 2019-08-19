package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/load")
    public String findAll(Model model){
        List<User> list=userService.findAll();
        System.out.println(list);
        model.addAttribute("list",list);
        return "/user2";
    }
}
