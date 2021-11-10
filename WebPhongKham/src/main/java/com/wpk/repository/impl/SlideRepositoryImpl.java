/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.google.protobuf.Int32Value;
import com.sun.xml.bind.v2.model.core.ID;
import com.wpk.pojos.Slide;
import com.wpk.repository.SlideRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Controller
@Transactional
public class SlideRepositoryImpl implements SlideRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Slide> getSlides(int page, String quantity) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Slide> query = builder.createQuery(Slide.class);
        Root root = query.from(Slide.class);
        query = query.select(root);
        
        Query q = session.createQuery(query);
        if(quantity.equals("All") == false){
            int max = Integer.parseInt(quantity);
            q.setMaxResults(max);
            q.setFirstResult((page - 1) * max);
        }
        return q.getResultList();  
    }

    @Override
    public Slide getSlideByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Slide.class, id);
    }

    @Override
    public boolean addOrUpdate(Slide slide) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try{
            
            session.saveOrUpdate(slide);
            
            return true;
        }
        catch(Exception e){
            System.err.println("==ADD PRODUCT===" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeSlide(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Slide s = this.getSlideByID(id);
        try{
            session.delete(s);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
    
    //get slides with search and paging
    @Override
    public List<Slide> getSlides(String kw, String active,String pageQuan, int pageNum) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Slide> query = builder.createQuery(Slide.class);
        Root root = query.from(Slide.class);
        query = query.select(root);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if(kw != null && !kw.isEmpty()){
            Predicate p = builder.like(root.get("title").as(String.class), String.format("%%%s%%", kw));
            predicates.add(p);
        }
        if(active != null && !active.isEmpty() && !active.equals("all") ){
            boolean a = Boolean.parseBoolean(active);
            System.out.println(active+"+++++++++++++++");
            Predicate p = builder.equal(root.get("active").as(boolean.class), a);
            predicates.add(p);
        }
        query = query.where(builder.and(predicates.toArray(new Predicate[] {})));
        Query q = session.createQuery(query);
        if(pageQuan != null && !pageQuan.isEmpty() && !pageQuan.equals("all") ){
            int max = Integer.parseInt(pageQuan);
            q.setMaxResults(max);
            q.setFirstResult((pageNum- 1) * max);
        }
            return q.getResultList();
    }
    
    @Override
    public long countSlide(String kw, String active) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Slide p where p.title LIKE :kw ";
        if(!active.equals("all"))
            query = query + "and p.active = :active";
        Query q = session.createQuery(query);
        if(!active.equals("all")){
             boolean a = Boolean.parseBoolean(active);
            q.setParameter("active", a);
        }
        q.setParameter("kw", "%%" + kw + "%%");
     
        return Long.parseLong(q.getSingleResult().toString());
    }
}
