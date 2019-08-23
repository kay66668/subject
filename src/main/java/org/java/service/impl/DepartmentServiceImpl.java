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
    public List<Department> getList1() {
        return mapper.getList1();
    }
}
