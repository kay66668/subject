package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author:严辉
 * @Date: 2019/8/19 10:48
 * @Description
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/load","/load/{page}"})
    public String findAll(Model model, @PathVariable(value = "page",required = false) Integer page,String username){

        if(page==null){
            page=1;
        }
        int rows=3;
        int count=userService.findCount(username);
        int maxPage=count%rows==0?count/rows:count/rows+1;
        List<User> list=userService.findAll(page,rows,username);
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute("count",count);
        model.addAttribute("maxPage",maxPage);
        return "/user2";

    }

    @GetMapping("add")
    public String addUser(@RequestParam Map<String,Object> map){

        int post=0;
        int departmentid=0;
        if(map.get("departmentid").toString().equals("人事部")){
            departmentid= 1;
            if(map.get("post").toString().equals("人事专员")){
                post=1;
            }else{
                post=2;
            }
        }else if(map.get("departmentid").toString().equals("财务部")){
               departmentid=2;
            if(map.get("post").toString().equals("出纳")){
                post=3;
            }else if(map.get("post").toString().equals("会计")){
                post=4;
            }else{
                post=5;
            }
        }else if(map.get("departmentid").toString().equals("总经办")){
                departmentid=3;
            if(map.get("post").toString().equals("总经理")){
                  post=6;
            }else if(map.get("post").toString().equals("行政助理")){
                  post=7;
            }else{
                  post=8;
            }
        }else if(map.get("departmentid").toString().equals("销售部")){
               departmentid=4;
            if(map.get("post").toString().equals("销售专员")){
                  post=9;
            }else{
                  post=10;
            }
        }else{
               departmentid=5;
            if(map.get("post").toString().equals("普通职员")){
                  post=11;
            }else{
                  post=12;
            }
        }

        User user=new User();
        user.setShowname(map.get("showname").toString());
        user.setUsername(map.get("username").toString());
        user.setPwd(map.get("pwd").toString());
        user.setDepartmentid(departmentid);
        user.setPost(post);
        user.setTel(map.get("tel").toString());
        userService.addUser(user);
        return "redirect:load";
    }

    @GetMapping("modify/{id}")
    public String detail(@PathVariable("id")Integer id ,Model model){
        User user=userService.selectUser(id);
        model.addAttribute("user",user);
        return "updateUser";
    }


    @GetMapping("update")
    public String update(@RequestParam Map<String,Object> map){
        int post=0;
        int departmentid=0;
        if(map.get("departmentid").toString().equals("人事部")){
            departmentid= 1;
            if(map.get("post").toString().equals("人事专员")){
                post=1;
            }else{
                post=2;
            }
        }else if(map.get("departmentid").toString().equals("财务部")){
            departmentid=2;
            if(map.get("post").toString().equals("出纳")){
                post=3;
            }else if(map.get("post").toString().equals("会计")){
                post=4;
            }else{
                post=5;
            }
        }else if(map.get("departmentid").toString().equals("总经办")){
            departmentid=3;
            if(map.get("post").toString().equals("总经理")){
                post=6;
            }else if(map.get("post").toString().equals("行政助理")){
                post=7;
            }else{
                post=8;
            }
        }else if(map.get("departmentid").toString().equals("销售部")){
            departmentid=4;
            if(map.get("post").toString().equals("销售专员")){
                post=9;
            }else{
                post=10;
            }
        }else{
            departmentid=5;
            if(map.get("post").toString().equals("普通职员")){
                post=11;
            }else{
                post=12;
            }
        }

        User user=new User();
        user.setId(Integer.parseInt(map.get("id").toString()));
        user.setShowname(map.get("showname").toString());
        user.setUsername(map.get("username").toString());
        user.setPwd(map.get("pwd").toString());
        user.setDepartmentid(departmentid);
        user.setTel(map.get("tel").toString());
        user.setPost(post);
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:load";
    }


    @GetMapping("del/{id}")
    public String delUser(@PathVariable("id") Integer id){
        userService.delUser(id);
        return  "redirect:/load";
    }

}
