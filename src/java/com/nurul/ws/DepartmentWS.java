/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.DepartmentDaoImpl;
import com.nurul.entity.Department;
import com.nurul.entity.Faculty;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Nurul 1672035
 */
@WebService(serviceName = "DepartmentWS")
public class DepartmentWS {

    private DepartmentDaoImpl departmentDaoImpl;

    public DepartmentWS() {
        departmentDaoImpl = new DepartmentDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddDepartment")
    public Integer AddDepartment(
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name,
            @WebParam(name = "faculty_id") int faculty_id) {
        Department dep = new Department();
        dep.setCode((short) code);
        dep.setName(name);
        Faculty fac = new Faculty();
        fac.setId(faculty_id);
        dep.setFaculty(fac);
        return departmentDaoImpl.save(dep);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateDepartmentWS")
    public Integer updateDepartmentWS(
            @WebParam(name = "id") int id,
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name,
            @WebParam(name = "faculty_id") int faculty_id) {
        Department dep = new Department();
        dep.setCode((short) code);
        dep.setName(name);
        Faculty fac = new Faculty();
        fac.setId(faculty_id);
        dep.setFaculty(fac);
        return departmentDaoImpl.update(dep);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteDepartmentWS")
    public Integer deleteDepartmentWS(
            @WebParam(name = "id") int id) {
        Department dep = new Department();
        dep.setId(id);
        return departmentDaoImpl.delete(dep);

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAllDepartmentWS")
    public List<Department> showAllDepartmentWS() {
        return departmentDaoImpl.findAll();
    }

}
