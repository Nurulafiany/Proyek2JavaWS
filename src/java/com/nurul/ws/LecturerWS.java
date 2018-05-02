/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.DepartmentDaoImpl;
import com.nurul.dao.LecturerDaoImpl;
import com.nurul.entity.Department;
import com.nurul.entity.Lecturer;
import com.nurul.entity.Rolelecturer;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Nurul 1672035
 */
@WebService(serviceName = "LecturerWS")
public class LecturerWS {

    private LecturerDaoImpl lecturerDaoImpl;
    private DepartmentDaoImpl departmentDaoImpl;

    public LecturerWS() {
        lecturerDaoImpl = new LecturerDaoImpl();
        departmentDaoImpl = new DepartmentDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addLecturer")
    public Integer addLecturer(
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id,
            @WebParam(name = "roleLecturer_id") int roleLecturer_id) {
        List<Department> departments = departmentDaoImpl.findAll();
//        List<Department> candidateDepartments = departments.stream().filter(p -> p.getCode().equalsIgoneCase(department_id)).collect(Collectors.toList());
        Lecturer lecturer = new Lecturer();
        lecturer.setName(name);
        lecturer.setPassword(password);
        Department dep = new Department();
        dep.setId(department_id);
        lecturer.setDepartment(dep);
        Rolelecturer rolelecturer = new Rolelecturer();
        rolelecturer.setId(roleLecturer_id);
        lecturer.setRolelecturer(rolelecturer);
        return lecturerDaoImpl.save(lecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateLecturer")
    public Integer updateLecturer(
            @WebParam(name = "nik") String nik,
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id,
            @WebParam(name = "roleLecturer_id") int roleLecturer_id) {
        List<Department> departments = departmentDaoImpl.findAll();
//        List<Department> candidateDepartments = departments.stream().filter(p -> p.getCode().equalsIgoneCase(department_id)).collect(Collectors.toList());
        Lecturer lecturer = new Lecturer();
        lecturer.setNik(nik);
        lecturer.setName(name);
        lecturer.setPassword(password);
        Department dep = new Department();
        dep.setId(department_id);
        lecturer.setDepartment(dep);
        Rolelecturer rolelecturer = new Rolelecturer();
        rolelecturer.setId(roleLecturer_id);
        lecturer.setRolelecturer(rolelecturer);
        return lecturerDaoImpl.update(lecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteLecturer")
    public Integer deleteLecturer(
            @WebParam(name = "nik") String nik) {
        List<Department> departments = departmentDaoImpl.findAll();
//        List<Department> candidateDepartments = departments.stream().filter(p -> p.getCode().equalsIgoneCase(department_id)).collect(Collectors.toList());
        Lecturer lecturer = new Lecturer();
        lecturer.setNik(nik);
        return lecturerDaoImpl.delete(lecturer);
    }
}
