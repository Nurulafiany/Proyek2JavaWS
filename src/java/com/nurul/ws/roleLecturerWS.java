/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.RolelecturerDaoImpl;
import com.nurul.entity.Rolelecturer;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Nurul 1672035
 */
@WebService(serviceName = "roleLecturer")
public class roleLecturerWS {

    private RolelecturerDaoImpl rolelecturerDaoImpl;

    public roleLecturerWS(Rolelecturer rolelecturer) {
        rolelecturer = new Rolelecturer();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addRoleLecturer")
    public Integer addRoleLecturer(
            @WebParam(name = "Status") String Status) {
        Rolelecturer rolelecturer = new Rolelecturer();
        rolelecturer.setStatus(Status);
        return rolelecturerDaoImpl.save(rolelecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateRoleLecturer")
    public Integer updateRoleLecturer(
            @WebParam(name = "id") int id,
            @WebParam(name = "Status") String Status) {
        Rolelecturer rolelecturer = new Rolelecturer();
        rolelecturer.setId(id);
        rolelecturer.setStatus(Status);
        return rolelecturerDaoImpl.update(rolelecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteRoleLecturer")
    public Integer deleteRoleLecturer(
            @WebParam(name = "id") int id) {
        Rolelecturer rolelecturer = new Rolelecturer();
        rolelecturer.setId(id);
        return rolelecturerDaoImpl.delete(rolelecturer);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showAllRole")
    public java.util.List<Rolelecturer> showAllRole() {
        //TODO write your implementation code here:
        return rolelecturerDaoImpl.findAll();
    }
}
