/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Nurse;
import com.wpk.repository.NurseRepository;
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
public class NurseRepositoryImpl implements NurseRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
 @Override
    public List<Nurse> getNurses() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Nurse");
        return q.getResultList();
    }

    @Override
    public Nurse getNurseByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Nurse.class, id);
    }

    @Override
    public boolean addOrUpdate(Nurse m) {
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
    public boolean removeNurse(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Nurse m = this.getNurseByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
}
