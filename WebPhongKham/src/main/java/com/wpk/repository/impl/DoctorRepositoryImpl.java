/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;


import com.wpk.pojos.Doctor;
import static com.wpk.pojos.Doctor_.id;
import static com.wpk.pojos.Doctor_.medicalExaminationCards;
import com.wpk.pojos.User;
import com.wpk.repository.DoctorRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;



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
        catch(HibernateException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Doctor> getDoctors(String firstName, String lastName, String medID, String account, String pageQuan, int pageNum) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
        Root root = query.from(Doctor.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
      
        if(firstName != null && !firstName.isEmpty()){
            Predicate p = builder.like(root.get("firstName").as(String.class), String.format("%%%s%%", firstName));
            predicates.add(p);
        }
        if(lastName != null && !lastName.isEmpty()){
             Predicate p = builder.like(root.get("lastName").as(String.class), String.format("%%%s%%", lastName));
            predicates.add(p);
        }
        if(medID != null && !medID.isEmpty() && !medID.equals("all") ){
             Predicate p = builder.equal(root.get("medical").get("id").as(Integer.class), Integer.parseInt(medID));
            predicates.add(p);
        }
        if(account != null && !account.isEmpty() && !account.equals("all")){
            if(account.equals("0")){
                 Predicate p = builder.isNull(root.get("user").as(User.class));
                predicates.add(p);
            }
            else if(account.equals("1")){
                Predicate p = builder.isNotNull(root.get("user").as(User.class));
                predicates.add(p);  
                
            }
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
    public Long countDoctor(String firstName, String lastName, String medID, String account) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Doctor p where p.firstName LIKE :firstName and p.lastName LIKE :lastName";
        if(medID != null && !medID.equals("all") && !medID.isEmpty())
            query = query + " and p.medical.id = :medID";
        
        if(!account.equals("all") && !account.isEmpty() ){
            if(account.equals("0"))
                query = query + " and p.user is null";
            else if(account.equals("1"))
                query = query + " and p.user is not null";
        }
        Query q = session.createQuery(query);      
        if(medID != null &&!medID.equals("all") && !medID.isEmpty()){
            q.setParameter("medID", Integer.parseInt(medID));
        }
         
        q.setParameter("firstName", "%%" + firstName + "%%");
        q.setParameter("lastName", "%%" + lastName + "%%");
     
        return Long.parseLong(q.getSingleResult().toString());
    }
    
    
}

  
