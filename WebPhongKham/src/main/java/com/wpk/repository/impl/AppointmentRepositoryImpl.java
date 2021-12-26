/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Appointment;
import com.wpk.pojos.User;
import com.wpk.repository.AppointmentRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;

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
public class AppointmentRepositoryImpl implements AppointmentRepository{
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<Appointment> getAppointments() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Appointment");
        return q.getResultList();
    }

    @Override
    public Appointment getAppointmentByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Appointment.class, id);
    }

    @Override
    public boolean addOrUpdate(Appointment m) {
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
    public boolean removeAppointment(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Appointment m = this.getAppointmentByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
    
    @Override
    public List<Appointment> getAppointments(String appointmentID, String patientID, String pageQuan, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Appointment> query = builder.createQuery(Appointment.class);
        Root root = query.from(Appointment.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
       
        if(appointmentID != null && !appointmentID.isEmpty()){
            Predicate p = builder.equal(root.get("appointmentId").as(Integer.class),Integer.parseInt(appointmentID));
            predicates.add(p);
        }
        else{
            if(patientID != null && !patientID.isEmpty()){
                Predicate p = builder.equal(root.get("patient").get("id").as(Integer.class),Integer.parseInt(patientID));
                predicates.add(p);
            }
        }
        
        query = query.where(builder.and(predicates.toArray(new Predicate[] {})));
       
        org.hibernate.query.Query q = session.createQuery(query);
        if(pageQuan != null && !pageQuan.isEmpty() && !pageQuan.equals("all") ){
            int max = Integer.parseInt(pageQuan);
            q.setMaxResults(max);
            q.setFirstResult((page- 1) * max);
        }
            return q.getResultList();
    }
    @Override
    public long countAppointments(String appointmentID, String patientID) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Appointment p ";
        if(appointmentID != null && !appointmentID.isEmpty())
            query = query + "Where p.id = :appointmentID";
        else{
            if(patientID != null && !patientID.isEmpty())
            query = query + "Where p.patient.id = :patientID";   
        }
        org.hibernate.query.Query q = session.createQuery(query);      
        if(appointmentID != null && !appointmentID.isEmpty()){
            q.setParameter("appointmentID", Integer.parseInt(appointmentID));
        }
         else{
            if(patientID != null && !patientID.isEmpty()) 
                q.setParameter("patientID", Integer.parseInt(patientID));
              }
        return Long.parseLong(q.getSingleResult().toString());
    }
    
}
