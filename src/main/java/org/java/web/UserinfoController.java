package org.java.web;

import org.java.entity.Userinfo;
import org.java.service.UserService;
import org.java.service.UserinfoService;
import org.java.util.UserinfoMessage;
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

    @RequestMapping("/addUserinfo")
    @ResponseBody
    public void add(Userinfo userinfo){
        userinfoService.add(userinfo);
    }

    @RequestMapping("/updateUserinfo")
    @ResponseBody
    public void update(Userinfo userinfo){
        userinfoService.update(userinfo);
    }



    @RequestMapping("/delUserinfo")
    @ResponseBody
    public void del(Integer userid){
        userinfoService.del(userid);
    }

    @GetMapping("getList")
    public Map getList(Integer page,Integer limit,String tel,String postbox){
        Map map = new HashMap();

        List<UserinfoMessage> list = userinfoService.getList(page,limit,tel,postbox);
        int count = userinfoService.getCount(tel,postbox);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);


        return map;

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
