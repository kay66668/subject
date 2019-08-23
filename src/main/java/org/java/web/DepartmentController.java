package org.java.web;

import org.java.entity.Department;
import org.java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/getList1")
    @ResponseBody
    public List getList1(Model model){
        List<Department> list = departmentService.getList1();

        model.addAttribute("list",list);

        return list;
    }
}
