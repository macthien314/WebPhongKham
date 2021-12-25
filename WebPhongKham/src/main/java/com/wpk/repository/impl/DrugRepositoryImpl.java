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
import java.util.Date;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
    public boolean removeDrug(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Drug m = this.getDrugByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addOrUpdate(Drug m) {
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
    public List<Drug> getDrugs(String name, String pageQuan, int pageNum) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drug> query = builder.createQuery(Drug.class);
        Root root = query.from(Drug.class);
        query = query.select(root);
        
        if(name != null && !name.isEmpty()){
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", name));
            query = query.where(p);
        }
       
        org.hibernate.Query q = session.createQuery(query);
        if(pageQuan != null && !pageQuan.isEmpty() && !pageQuan.equals("all") ){
            int max = Integer.parseInt(pageQuan);
            q.setMaxResults(max);
            q.setFirstResult((pageNum- 1) * max);
        }
            return q.getResultList();
    }

    @Override
    public long countDrug(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Drug d where d.name LIKE :name ";
       
        org.hibernate.Query q = session.createQuery(query);
        
        q.setParameter("name", "%%" + name + "%%");
     
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Drug> getUnexpiredDrug() {
        Date d = new Date(); 
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="FROM Drug d where expiry > :date";
        
        org.hibernate.Query q = session.createQuery(query);
        q.setParameter("date", d);
        return q.getResultList();
    }
    
}
