/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Medical;
import com.wpk.repository.MedicalRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Medical> getMedicals(String name, String pageQuan, int pageNum) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Medical> query = builder.createQuery(Medical.class);
        Root root = query.from(Medical.class);
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
    public long countMedical(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Medical s where s.name LIKE :name ";
       
        org.hibernate.Query q = session.createQuery(query);
        
        q.setParameter("name", "%%" + name + "%%");
     
        return Long.parseLong(q.getSingleResult().toString());
    }
    

  
}
