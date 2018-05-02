/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.AcademicYearDaoImpl;
import com.nurul.entity.AcademicYear;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "academicYearWS")
public class academicYearWS {

    private AcademicYearDaoImpl academicYearDaoImpl;

    public academicYearWS(AcademicYearDaoImpl academicYearDaoImpl) {
        academicYearDaoImpl = new AcademicYearDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAcademicYear")
    public Integer addAcademicYear(
            @WebParam(name = "name") String name) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setName(name);
        return academicYearDaoImpl.save(academicYear);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateAcademicYear")
    public Integer updateAcademicYear(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setId(id);
        academicYear.setName(name);
        return academicYearDaoImpl.update(academicYear);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteAcademicYear")
    public Integer deleteAcademicYear(
            @WebParam(name = "id") int id) {
        AcademicYear academicYear = new AcademicYear();
        academicYear.setId(id);
        return academicYearDaoImpl.save(academicYear);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAllAcademicYear")
    public java.util.List<AcademicYear> showAllAcademicYear() {
        return academicYearDaoImpl.findAll();
    }

}
