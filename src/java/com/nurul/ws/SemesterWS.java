/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.SemesterDaoImpl;
import com.nurul.entity.Semester;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Nurul 1672035
 */
@WebService(serviceName = "Semester")
public class SemesterWS {

    private SemesterDaoImpl semesterDaoImpl;

    public SemesterWS() {
        semesterDaoImpl = new SemesterDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addSemester")
    public Integer addSemester(
            @WebParam(name = "name") String name) {
        Semester semester = new Semester();
        semester.setName(name);
        return semesterDaoImpl.save(semester);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateSemester")
    public Integer updateSemester(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        Semester semester = new Semester();
        semester.setName(name);
        return semesterDaoImpl.delete(semester);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteSemester")
    public Integer deleteSemester(
            @WebParam(name = "id") int id) {
        Semester semester = new Semester();
        semester.setId(id);
        return semesterDaoImpl.delete(semester);
    }
}
