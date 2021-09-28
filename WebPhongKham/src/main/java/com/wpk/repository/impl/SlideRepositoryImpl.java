/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.sun.xml.bind.v2.model.core.ID;
import com.wpk.pojos.Slide;
import com.wpk.repository.SlideRepository;
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
            session.save(slide);
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
    
}
