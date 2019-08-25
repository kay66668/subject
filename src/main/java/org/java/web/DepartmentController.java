package org.java.web;

import org.java.entity.Department;
import org.java.entity.Userinfo;
import org.java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/addDepartment")
    @ResponseBody
    public void add(Department department){
        departmentService.add(department);
    }

    @RequestMapping("/updateDepartment")
    @ResponseBody
    public void update(Department department){
        departmentService.update(department);
    }


    @RequestMapping("/delDepartment")
    @ResponseBody
    public void del(Integer id){
        departmentService.del(id);
    }

    @RequestMapping("getList1")
    @ResponseBody
    public Map getList(Integer page, Integer limit, String name, String leader){
        Map map = new HashMap();

        List<Department> list = departmentService.getList1(page,limit,name,leader);
        int count = departmentService.getCount1(name,leader);

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);

        return map;

    }
}
