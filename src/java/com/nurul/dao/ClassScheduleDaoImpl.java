/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.ClassSchedule;
import com.nurul.utility.DaoService;
import com.nurul.utility.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nurul 1672035
 */
public class ClassScheduleDaoImpl implements DaoService<ClassSchedule> {

    @Override
    public int save(ClassSchedule t) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(t);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int delete(ClassSchedule t) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(t);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int update(ClassSchedule t) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(t);
            transaction.commit();
            result = 1;
        } catch (HibernateException e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<ClassSchedule> findAll() {
        List<ClassSchedule> classSchedules = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ClassSchedule.class);
        classSchedules.addAll(criteria.list());
        session.close();
        return classSchedules;
    }

    @Override
    public ClassSchedule find(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ClassSchedule.class)
                .add(Restrictions.eq("name", object.toString()))
                .setMaxResults(1);
        //name diatas untuk mengubah nama sesuai yang diinginkan dan sesuai yg di dbnya
        if (criteria.list().isEmpty()) {
            return null;
        }
        return ((ClassSchedule) criteria.list().get(0));
    }

}
