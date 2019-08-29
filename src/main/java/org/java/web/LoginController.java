package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author:严辉
 * @Date: 2019/8/16 15:59
 * @Description
 */

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("init")
    public String init(){

        return "login";
    }

    @PostMapping("/login")
    public String findUser(String username, String pwd, HttpServletRequest request){

        User map=userService.findUser(username,pwd);
        if(map==null){
            HttpSession ses=request.getSession();
            ses.setAttribute("err","用户名或者密码错误");
            return "/login";
        }else {
            request.setAttribute("user",map);

            return  "/index";
        }
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        request.removeAttribute("user");
        return "redirect:/init";
    }
}
