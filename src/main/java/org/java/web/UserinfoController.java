package org.java.web;

import org.java.entity.Userinfo;
import org.java.service.UserService;
import org.java.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserinfoController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/add")
    @ResponseBody
    public void add(Userinfo userinfo){
        userinfoService.add(userinfo);
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(Userinfo userinfo){
        userinfoService.update(userinfo);
    }

    @RequestMapping("/del")
    @ResponseBody
    public void del(Integer userid){
        userinfoService.del(userid);
    }

    @GetMapping("/getList")
    public String getList(Model model){
        List<Userinfo> list = userinfoService.getList();

        model.addAttribute("list",list);

        return "/forward/user";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
