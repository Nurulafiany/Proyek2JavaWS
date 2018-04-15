/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurul.dao;

import com.nurul.entity.AcademicYear;
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
public class AcademicYearDaoImpl implements DaoService<AcademicYear> {

    @Override
    public int save(AcademicYear t) {
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
    public int delete(AcademicYear t) {
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
    public int update(AcademicYear t) {
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
    public List<AcademicYear> findAll() {
        List<AcademicYear> academicYears = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AcademicYear.class);
        academicYears.addAll(criteria.list());
        session.close();
        return academicYears;
    }

    @Override
    public AcademicYear find(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AcademicYear.class)
                .add(Restrictions.eq("name", object.toString()))
                .setMaxResults(1);
        //name diatas untuk mengubah nama sesuai yang diinginkan dan sesuai yg di dbnya
        if (criteria.list().isEmpty()) {
            return null;
        }
        return ((AcademicYear) criteria.list().get(0));
    }

}
