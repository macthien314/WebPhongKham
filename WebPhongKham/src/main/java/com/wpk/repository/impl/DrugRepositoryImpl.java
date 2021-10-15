/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Drug;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.wpk.repository.DrugRepository;
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
public class DrugRepositoryImpl implements DrugRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Drug> getDrugs() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Drug");
        return q.getResultList();
    }

    @Override
    public Drug getDrugByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Drug.class, id);
    }

    @Override
    public boolean addOrUpdate(Drug m) {
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
