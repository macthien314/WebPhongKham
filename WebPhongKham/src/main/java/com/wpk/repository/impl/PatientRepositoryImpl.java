/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Patient;
import com.wpk.repository.PatientRepository;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Query;
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
public class PatientRepositoryImpl implements PatientRepository {
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<Patient> getPatients() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Patient");
        return q.getResultList();
    }

    @Override
    public Patient getPatientByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Patient.class, id);
    }

    @Override
    public boolean addOrUpdate(Patient m) {
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
     @Override
    public boolean removePatient(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Patient m = this.getPatientByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
    
}

