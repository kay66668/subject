package org.java.web;

import org.java.entity.TMeet;

import org.java.service.MeetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MeetController {
    @Autowired
    private MeetService meetService;

    @RequestMapping("/addMeet")
    @ResponseBody
    public void add(TMeet meet){
        meetService.add(meet);
    }

    @RequestMapping("/updateMeet")
    @ResponseBody
    public void update(TMeet meet){
        meetService.update(meet);
    }



    @RequestMapping("/delMeet")
    @ResponseBody
    public void del(Integer id){
        meetService.del(id);
    }

    @RequestMapping("getMeetList")
    @ResponseBody
    public Map getList(Integer page, Integer limit, String createBy, String title){
        Map map = new HashMap();

        List<TMeet> list = meetService.getMeetList(page,limit,createBy,title);
        int count = meetService.getCount(createBy,title);

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

