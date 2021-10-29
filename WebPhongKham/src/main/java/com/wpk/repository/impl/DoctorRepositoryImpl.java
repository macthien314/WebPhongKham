/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;


import com.wpk.pojos.Doctor;
import com.wpk.repository.DoctorRepository;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;



import org.hibernate.Session;
import org.hibernate.query.Query;
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
    public List<Doctor> getDoctor(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Doctor> q = builder.createQuery(Doctor.class);
        Root root = q.from(Doctor.class);
        q=q.select(root);
        
        if (kw != null)
        {
            Predicate p = builder.like(root.get("firstName").as(String.class),
                    String.format("%%s%%", kw));
            q = q.where(p);
        }
        q = q.orderBy(builder.asc(root.get("id")));
        Query query = s.createQuery(q);
        
        int max = 3;
        query.setMaxResults(max);
        query.setFirstResult((page-1)* max);
        return query.getResultList();
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
    public boolean removeDoctor(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Doctor m = this.getDoctorByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }

    @Override
    public long countDoctor() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("Select Count(*) From Doctor ");
        return Long.parseLong(q.getSingleResult().toString());
    }
}

  
