/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.ws;

import com.nurul.dao.ClassScheduleDaoImpl;
import com.nurul.dao.ClassScheduleIdDaoImpl;
import javax.jws.WebService;

/**
 *
 * @author Nurul 1672035
 */
@WebService(serviceName = "ClassScheduleWS")
public class ClassScheduleWS {

    private ClassScheduleDaoImpl classScheduleDaoImpl;
    private ClassScheduleIdDaoImpl classScheduleIdDaoImpl;

    public ClassScheduleWS() {
        classScheduleDaoImpl = new ClassScheduleDaoImpl();
        classScheduleIdDaoImpl = new ClassScheduleIdDaoImpl();
    }

}
