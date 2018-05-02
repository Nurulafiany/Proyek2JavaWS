/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.DepartmentDaoImpl;
import com.nurul.dao.StudentDaoImpl;
import com.nurul.entity.Department;
import com.nurul.entity.Student;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "Student")
public class StudentWS {

    private StudentDaoImpl studentDaoImpl;
    private DepartmentDaoImpl departmentDaoImpl;

    public StudentWS() {
        studentDaoImpl = new StudentDaoImpl();
        departmentDaoImpl = new DepartmentDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addStudentWS")
    public Integer addStudentWS(
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id) {
        List<Department> departments = departmentDaoImpl.findAll();
//        List<Department> candidateDepartments = departments.stream().filter(p -> p.getCode().equalsIgoneCase(department_id)).collect(Collectors.toList());
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        Department dep = new Department();
        dep.setId(department_id);
        student.setDepartment(dep);
        return studentDaoImpl.save(student);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudentWS")
    public Integer updateStudentWS(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name,
            @WebParam(name = "password") String password,
            @WebParam(name = "department_id") int department_id) {
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        Department dep = new Department();
        dep.setId(department_id);
        student.setDepartment(dep);
        return studentDaoImpl.update(student);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudentWS")
    public Integer deleteStudentWS(
            @WebParam(name = "id") String id,
            @WebParam(name = "department_id") int department_id) {
        Student student = new Student();
        Department dep = new Department();
        dep.setId(department_id);
        student.setDepartment(dep);
        return studentDaoImpl.delete(student);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAllStudent")
    public java.util.List<Student> showAllStudent() {
        //TODO write your implementation code here:
        return studentDaoImpl.findAll();
    }
}
