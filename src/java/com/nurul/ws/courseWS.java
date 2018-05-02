/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.CourseDaoImpl;
import com.nurul.entity.Course;
import com.nurul.entity.Department;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Nurul 1672035
 */
@WebService(serviceName = "courseWS")
public class courseWS {

    private CourseDaoImpl courseDaoImpl;

    public courseWS() {
        courseDaoImpl = new CourseDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCourseWS")
    public Integer addCourseWS(
            @WebParam(name = "name") String name,
            @WebParam(name = "theory_credits") int theory_credits,
            @WebParam(name = "practicum_credits") int practicum_credits,
            @WebParam(name = "department_id") int department_id) {
        Course course = new Course();
        course.setName(name);
        course.setTheoryCredits((short) theory_credits);
        course.setPracticumCredits((short) practicum_credits);
        Department dep = new Department();
        dep.setId(department_id);
        course.setDepartment(dep);
        return courseDaoImpl.save(course);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateCourseWS")
    public Integer updateCourseWS(
            @WebParam(name = "id") String id,
            @WebParam(name = "name") String name,
            @WebParam(name = "theory_credits") int theory_credits,
            @WebParam(name = "practicum_credits") int practicum_credits,
            @WebParam(name = "department_id") int department_id) {
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setTheoryCredits((short) theory_credits);
        course.setPracticumCredits((short) practicum_credits);
        Department dep = new Department();
        dep.setId(department_id);
        course.setDepartment(dep);
        return courseDaoImpl.update(course);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCourseWS")
    public Integer deleteCourseWS(
            @WebParam(name = "id") String id) {
        Course course = new Course();
        course.setId(id);
        return courseDaoImpl.delete(course);
    }
}
