package org.java.service;

import org.java.entity.Department;

import java.util.List;

public interface DepartmentService {

    public void add(Department department);

    public void update(Department department);

    public void del(Integer id);

    public List<Department> getList1();
}
