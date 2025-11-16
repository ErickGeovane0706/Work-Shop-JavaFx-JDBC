package org.projetos.workshopjavafxjdbc.model.services;

import org.projetos.workshopjavafxjdbc.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    public List<Department> findAll() {
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "Books"));
        list.add(new Department(2, "Computer Science"));
        list.add(new Department(3, "ADS"));
        list.add(new Department(4, "Electronics"));
        list.add(new Department(5, "RH"));
        list.add(new Department(6, "Engineering"));
        return list;
    }
}
