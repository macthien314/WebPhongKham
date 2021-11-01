/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;


import com.wpk.pojos.Services;
import com.wpk.pojos.Slide;
import com.wpk.repository.ServicesRepository;
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
    
    @Override
    public boolean removeServices(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Services m = this.getServiceByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }

    @Override
    public long countService(String name) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Services s where s.name LIKE :name ";
       
        org.hibernate.Query q = session.createQuery(query);
        
        q.setParameter("name", "%%" + name + "%%");
     
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Services> getServices(String name, String pageQuan, int pageNum) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Services> query = builder.createQuery(Services.class);
        Root root = query.from(Services.class);
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
}
