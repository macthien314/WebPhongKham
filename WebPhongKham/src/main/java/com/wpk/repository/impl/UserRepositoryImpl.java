/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.User;
import com.wpk.repository.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch(HibernateException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    public boolean addDoctorUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            session.save(user);
            return true;
        }catch(HibernateException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    

    @Override
    public List<User> getUser (String username) {
       Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root root = query.from(User.class);
        query = query.select(root);
        if(!username.isEmpty())
        {   
            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
            query.where(p);
        }
        org.hibernate.Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<User> getUsers() {
        Session s = sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = s.createQuery("From User");
        return q.getResultList();
    }
    
}

