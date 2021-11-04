/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.repository.DoctorRepository;
import com.wpk.repository.PatientRepository;
import com.wpk.repository.PrescriptionRepository;
import com.wpk.utils.util;
import java.math.BigDecimal;

import java.util.Date;


import java.util.List;
import java.util.Map;
import org.hibernate.Query;


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
public class PrescriptionRepositoryImpl implements PrescriptionRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private DoctorRepository doctorRepository; 
    @Autowired
    private PatientRepository patientRepository; 
      
      @Override
    public List<Prescription> getPrescriptions() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Prescription");
        return q.getResultList();
    }

    @Override
    public Prescription getPrescriptionByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Prescription.class, id);
    }

    @Override
    public boolean addOrUpdate(Prescription m) {
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

    @Override
    public boolean addReceipt(Map<String, PrescriptionDrug> m) {
   
        Prescription p = new Prescription();
        p.setDoctor(this.doctorRepository.getDoctorByID(0));
        p.setPatient(this.patientRepository.getPatientByID(0));        
        p.setCreatedDate(new Date());
        
        Map<String, String> stats =util.invoiceStats(m);
        p.setTotalPrice(BigDecimal.ONE.parseLong(stats.get("amount")));
        
        return false;
    }
}
