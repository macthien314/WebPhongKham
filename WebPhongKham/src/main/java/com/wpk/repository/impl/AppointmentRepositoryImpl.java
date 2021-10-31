/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Appointment;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.repository.AppointmentRepository;
import java.util.List;
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
}
