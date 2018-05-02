/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.FacultyDaoImpl;
import com.nurul.entity.Faculty;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "FacultyWS")
public class FacultyWS {

    private FacultyDaoImpl facultyDaoImpl;

    public FacultyWS() {
        facultyDaoImpl = new FacultyDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addFaculty")
    public Integer addFaculty(
            @WebParam(name = "code") short code,
            @WebParam(name = "name") String name) {
        Faculty faculty = new Faculty();
        faculty.setCode(code);
        faculty.setName(name);
        return facultyDaoImpl.save(faculty);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateFaculty")
    public Integer updateFaculty(
            @WebParam(name = "id") int id,
            @WebParam(name = "code") short code,
            @WebParam(name = "name") String name) {
        Faculty faculty = new Faculty();
        faculty.setCode(code);
        faculty.setName(name);
        return facultyDaoImpl.update(faculty);

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteFaculty")
    public Integer deleteFaculty(
            @WebParam(name = "id") int id) {
        Faculty faculty = new Faculty();
        return facultyDaoImpl.save(faculty);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAllFaculty")
    public java.util.List<Faculty> showAllFaculty() {
        //TODO write your implementation code here:
        return facultyDaoImpl.findAll();
    }
}
