package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddressBookController {
    @Autowired
    private UserService userService;

    @RequestMapping("show")
    @ResponseBody
    public Map findAll2(Integer page, Integer limit, String showname){
        Map map=new HashMap();
        List<User> m=userService.findAll2(page,limit,showname);
        int count=userService.findCount2(showname);
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",m);

        return map;

    }
}
