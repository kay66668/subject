package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/login/{page}")
    public String login(@PathVariable("page") String page){
        return "/"+page;
    }

    @GetMapping("init")
    public String init(){
        return "login";
    }
}
