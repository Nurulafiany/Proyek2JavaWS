/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.RoomDaoImpl;
import com.nurul.entity.Room;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ASUS
 */
@WebService(serviceName = "RoomWS")
public class RoomWS {

    private RoomDaoImpl roomDaoImpl;

    public RoomWS() {
        roomDaoImpl = new RoomDaoImpl();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addRoom")
    public Integer AddSemester(
            @WebParam(name = "name") String name) {
        Room room = new Room();
        room.setName(name);
        return roomDaoImpl.save(room);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateRoom")
    public Integer updateSemester(
            @WebParam(name = "id") int id,
            @WebParam(name = "name") String name) {
        Room room = new Room();
        room.setName(name);
        return roomDaoImpl.update(room);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteRoom")
    public Integer deleteSemester(
            @WebParam(name = "id") int id) {
        Room room = new Room();
        room.setId(id);
        return roomDaoImpl.delete(room);
    }
}
