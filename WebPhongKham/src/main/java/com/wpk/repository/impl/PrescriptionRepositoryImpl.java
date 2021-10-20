/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;
import com.wpk.pojos.Prescription;
import com.wpk.repository.PrescriptionRepository;
import java.util.List;
import javax.persistence.Query;

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
public class PrescriptionRepositoryImpl implements PrescriptionRepository {
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<Prescription> getPrescriptions() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Prescription");
        return q.getResultList();
    }

    @Override
    public Prescription getPrescriptionByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Prescription.class, id);
    }

    @Override
    public boolean addOrUpdate(Prescription m) {
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
