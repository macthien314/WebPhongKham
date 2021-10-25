/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;


import com.wpk.pojos.Services;
import com.wpk.repository.ServicesRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class ServicesRepositoryImpl implements ServicesRepository{
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
     
  

    @Override
    public boolean addOrUpdate(Services s) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.saveOrUpdate(s);
            return true;
        }
        catch(Exception e){
            System.err.println("==ADD Service===" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Services> getServices() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Services");
        return q.getResultList();
    }

    @Override
    public Services getServiceByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Services.class, id);
    }
}
