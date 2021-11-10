
package com.wpk.repository.impl;

import com.wpk.pojos.DrugCart;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.repository.DoctorRepository;
import com.wpk.repository.DrugRepository;
import com.wpk.repository.PatientRepository;
import com.wpk.repository.PrescriptionRepository;
import com.wpk.utils.util;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Date;


import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
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
    private DrugRepository drugRepository; 
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
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<String, PrescriptionDrug> m, int id) {
        try{
             Session s = sessionFactory.getObject().getCurrentSession();
         
        Prescription p = new Prescription();
        p.setDoctor(this.doctorRepository.getDoctorByID(id));
        p.setPatient(this.patientRepository.getPatientByID(id));        
        p.setCreatedDate(new Date());
        
        Map<String, String> stats =util.invoiceStats(m);
        //p.setTotalPrice(BigDecimal.valueOf(Double.valueOf(stats.get("amount"))));
        
        s.saveOrUpdate(p);    
         return true;   
        }
        catch(HibernateException ex){
            ex.printStackTrace();  
        } 
        return false;
    }
    
        @Override
    public boolean removePrescription(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Prescription m = this.getPrescriptionByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }

    @Override
    public List<Prescription> getPrescriptions(String presID, String patientID, String pageQuan, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Prescription> query = builder.createQuery(Prescription.class);
        Root root = query.from(Prescription.class);
        
        List<Predicate> predicates = new ArrayList<Predicate>();
       
        if(presID != null && !presID.isEmpty()){
            Predicate p = builder.equal(root.get("id").as(Integer.class),Integer.parseInt(presID));
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
    public long countPresciptions(String presID, String patientID) {
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM Prescription p ";
        if(presID != null && !presID.isEmpty())
            query = query + "Where p.id = :presID";
        else{
            if(patientID != null && !patientID.isEmpty())
            query = query + "Where p.patient.id = :patientID";   
        }
        org.hibernate.query.Query q = session.createQuery(query);      
        if(presID != null && !presID.isEmpty()){
            q.setParameter("presID", Integer.parseInt(presID));
        }
         else{
            if(patientID != null && !patientID.isEmpty()) 
                q.setParameter("patientID", Integer.parseInt(patientID));
              }
        return Long.parseLong(q.getSingleResult().toString());
   }
    
    //tạo mào toa thuốc đồng thời hoàn thành phiếu khám
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addPrescription(Prescription p,MedicalExaminationCard m, Map<Integer,DrugCart> map){
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            p.setCreatedDate(new Date());
            p.setDoctor(m.getDoctor());
            p.setPatient(m.getPatient());
            
            session.save(p);
            
            for(DrugCart c: map.values()){
                PrescriptionDrug d = new PrescriptionDrug();
                d.setPrescription(p);
                d.setDrug(this.drugRepository.getDrugByID(c.getDrugID()));
                d.setUserGuide(c.getUserGuide());
                d.setQuantity(c.getQuantity());
                session.save(d);
            }
            m.setReceive(true);
            session.saveOrUpdate(m);
            return true;
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

}
