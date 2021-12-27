

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.Nurse;
import com.wpk.pojos.Invoice;
import com.wpk.pojos.Medical;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Patient;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.pojos.Services;
import com.wpk.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Object[]> numPatientMonthStats(Date fromDate, Date toDate) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
         
        Root rootP = q.from(Patient.class);
        Root rootM = q.from(MedicalExaminationCard.class);
          
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootM.get("patient"), rootP.get("id")));
          
          
        q.multiselect(b.function("MONTH",Integer.class, rootM.get("date")),
        b.function("YEAR",Integer.class, rootM.get("date")),
        b.count(rootM.get("id")), b.countDistinct(rootP.get("id")));
            
        if(fromDate != null)
        {
           predicates.add(b.greaterThanOrEqualTo(rootM.get("date"), fromDate));
        }
        if(toDate != null)
        {
           predicates.add(b.lessThanOrEqualTo(rootM.get("date"), toDate));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));            
                    
        q.groupBy(b.function("MONTH",Integer.class, rootM.get("date")),
        b.function("YEAR",Integer.class, rootM.get("date")));       
        Query query = session.createQuery(q);    
        return query.getResultList();
    }

    //danh thu đến từ lập hóa đơn bán thuốc
    @Override
    public List<Object[]> invoiceMonthStats(Date fromDate, Date toDate) {
      
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootI = q.from(Invoice.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        
        
        
          
        q.multiselect( 
                b.function("MONTH",Integer.class, rootI.get("createdDate")),
        b.function("YEAR",Integer.class, rootI.get("createdDate")),

        b.sum(rootI.get("totalPrice"))); 
            
        if(fromDate != null)
        {
           predicates.add(b.greaterThanOrEqualTo(rootI.get("createdDate"), fromDate));
        }
        if(toDate != null)
        {
           predicates.add(b.lessThanOrEqualTo(rootI.get("createdDate"), toDate));
        }
        
        q.where(b.and(predicates.toArray(new Predicate[]{})));            
                    
        q.groupBy(b.function("MONTH",Integer.class, rootI.get("createdDate")),
        b.function("YEAR",Integer.class, rootI.get("createdDate"))); 
        
        Query query = session.createQuery(q);    
        return query.getResultList();
    }
    //danh thu đến từ lập phiếu khám
    @Override
    public List<Object[]> medCardRevenueMonthStats(Date fromDate, Date toDate) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootm = q.from(MedicalExaminationCard.class);
        
        List<Predicate> predicates = new ArrayList<>();
   
          
        q.multiselect( 
                b.function("MONTH",Integer.class, rootm.get("date")),
        b.function("YEAR",Integer.class, rootm.get("date")),

        b.sum(rootm.get("fee"))); 
            
        if(fromDate != null)
        {
           predicates.add(b.greaterThanOrEqualTo(rootm.get("date"), fromDate));
        }
        if(toDate != null)
        {
           predicates.add(b.lessThanOrEqualTo(rootm.get("date"), toDate));
        }
        
         q.where(b.and(predicates.toArray(new Predicate[]{})));        
                    
        q.groupBy(b.function("MONTH",Integer.class, rootm.get("date")),
        b.function("YEAR",Integer.class, rootm.get("date"))); 
        
        Query query = session.createQuery(q);    
        return query.getResultList();
    }
    
    //danh thu đến từ các hóa đơn dịch vụ
    @Override
    public List<Object[]> serviceInvoiceMonthStats(Date fromDate, Date toDate) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootm = q.from(ServiceInvoice.class);
        
        List<Predicate> predicates = new ArrayList<>();
             
          
        q.multiselect( 
                b.function("MONTH",Integer.class, rootm.get("createdDate")),
        b.function("YEAR",Integer.class, rootm.get("createdDate")),

        b.sum(rootm.get("fee"))); 
            
        if(fromDate != null)
        {
           predicates.add(b.greaterThanOrEqualTo(rootm.get("createdDate"), fromDate));
        }
        if(toDate != null)
        {
           predicates.add(b.lessThanOrEqualTo(rootm.get("createdDate"), toDate));
        }
        
         q.where(b.and(predicates.toArray(new Predicate[]{}))); 
                    
        q.groupBy(b.function("MONTH",Integer.class, rootm.get("createdDate")),
        b.function("YEAR",Integer.class, rootm.get("createdDate"))); 
        
        Query query = session.createQuery(q);    
        return query.getResultList();
    }

    @Override
    public List<Object[]> coutabout() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

          Root rootSI = q.from(ServiceInvoice.class);
          Root rootS = q.from(Services.class);
          Root rootN = q.from(Nurse.class);
          Root rootD = q.from(Doctor.class);
          Root rootM = q.from(Medical.class);
      
        
        List<Predicate> predicates = new ArrayList<>();     
        predicates.add(b.equal(rootSI.get("nurse"), rootN.get("id")));
        
        predicates.add(b.equal(rootSI.get("service"), rootS.get("id"))); 
        
        predicates.add(b.equal(rootD.get("medical"), rootM.get("id"))); 
        predicates.add(b.equal(rootN.get("medical"), rootM.get("id")));   
        
        q.multiselect( b.count(rootD.get("id")), b.count(rootN.get("id"))
                ,b.count(rootS.get("id")),b.count(rootM.get("id"))); 
        
   
        q.where(b.and(predicates.toArray(new Predicate[]{})));  
        
        Query query = session.createQuery(q);    
        return query.getResultList();
    }
}

