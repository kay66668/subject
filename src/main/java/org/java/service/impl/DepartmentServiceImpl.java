package org.java.service.impl;

import org.java.dao.DepartmentMapper;
import org.java.entity.Department;
import org.java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper mapper;

    @Override
    public void add(Department department) {
        mapper.insert(department);
    }

    @Override
    public void update(Department department) {
        mapper.updateByPrimaryKey(department);
    }

    @Override
    public void del(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Department> getList1(int page, int rows, String name, String leader) {
        int start = (page-1)*rows;

        return mapper.getList1(start,rows,name,leader);
    }

    @Override
    public int getCount1(String name, String leader) {
        return mapper.getCount1(name,leader);
    }

}
