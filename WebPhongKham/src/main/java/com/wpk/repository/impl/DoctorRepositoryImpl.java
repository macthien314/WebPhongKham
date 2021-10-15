/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;


import com.wpk.pojos.Doctor;
import com.wpk.repository.DoctorRepository;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author macth
 */
@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository {
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<Doctor> getDoctor() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Doctor");
        return q.getResultList();
    }

    @Override
    public Doctor getDoctorByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Doctor.class, id);
    }

    @Override
    public boolean addOrUpdate(Doctor m) {
         Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.save(m);
            return true;
        }
        catch(Exception e){
            System.err.println("==ADD PRODUCT===" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}

  