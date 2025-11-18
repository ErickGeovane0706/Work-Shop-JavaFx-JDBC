package org.projetos.workshopjavafxjdbc.model.services;

import org.projetos.workshopjavafxjdbc.model.dao.DaoFactory;
import org.projetos.workshopjavafxjdbc.model.dao.DepartmentDao;
import org.projetos.workshopjavafxjdbc.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private DepartmentDao dao= DaoFactory.createDepartmentDao();
    public List<Department> findAll() {
        return dao.findAll();


    }
}
