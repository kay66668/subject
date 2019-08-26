package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AddressBookController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/show","/show/{page}"})
    public String findAll2(Model model, @PathVariable(value = "page",required = false) Integer page, String showname){

        if(page==null){
            page=1;
        }
        int rows=3;
        int count=userService.findCount2(showname);
        int maxPage=count%rows==0?count/rows:count/rows+1;
        List<User> m=userService.findAll2(page,rows,showname);
        model.addAttribute("m",m);
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute("count",count);
        model.addAttribute("maxPage",maxPage);

        return "/addressBook";

    }
}
