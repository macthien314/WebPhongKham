/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Medical;
import com.wpk.repository.MedicalRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class MedicalRepositoryImpl implements MedicalRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Medical> getMedicals() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Medical");
        return q.getResultList();
    }

    @Override
    public Medical getMedicalByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Medical.class, id);
    }

    @Override
    public boolean addOrUpdate(Medical m) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(m);
            return true;
        }
        catch(Exception e){
            System.err.println("==ADD PRODUCT===" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
   @Override
    public boolean removeMedical(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Medical m = this.getMedicalByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
   
}
