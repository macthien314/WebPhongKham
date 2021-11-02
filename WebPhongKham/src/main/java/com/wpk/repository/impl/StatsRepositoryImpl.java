/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Drug;
import com.wpk.pojos.Invoice;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Patient;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.pojos.ServiceInvoice;
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
          
          
        q.multiselect( b.function("MONTH",Integer.class, rootM.get("date")),
        b.function("YEAR",Integer.class, rootM.get("date")),
        b.count(rootP.get("id")), b.countDistinct(rootP.get("id")));
            
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

    @Override
    public List<Object[]> invoiceMonthStats(Date fromDate, Date toDate) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
         
        Root rootP = q.from(Patient.class);
        Root rootM = q.from(MedicalExaminationCard.class);
        Root rootI = q.from(Invoice.class);
        Root rootSI = q.from(ServiceInvoice.class);
        Root rootPr = q.from(Prescription.class);
        Root rootPD = q.from(PrescriptionDrug.class);
        Root rootD = q.from(Drug.class);
        
        List<Predicate> predicates = new ArrayList<>();
       
        predicates.add(b.equal(rootSI.get("patient"), rootP.get("id")));
        predicates.add(b.equal(rootPr.get("patient"), rootP.get("id")));
        
        predicates.add(b.equal(rootI.get("prescription"), rootPr.get("id")));
        

        predicates.add(b.equal(rootPD.get("prescription"), rootPr.get("id")));
//        predicates.add(b.equal(rootPD.get("drug"), rootD.get("id")));
         predicates.add(b.equal(rootM.get("patient"), rootP.get("id")));
          
        q.multiselect( b.function("MONTH",Integer.class, rootM.get("date")),
        b.function("YEAR",Integer.class, rootM.get("date")),
        b.sum(rootM.get("fee") ,rootSI.get("fee")));
//        b.sum(b.sum(rootM.get("fee") ,rootSI.get("fee")), b.sum(b.prod(rootD.get("unitPrice"), rootD.get("quantity"))))); 
            
        if(fromDate != null)
        {
           predicates.add(b.greaterThanOrEqualTo(rootI.get("createdDay"), fromDate));
        }
        if(toDate != null)
        {
           predicates.add(b.lessThanOrEqualTo(rootI.get("createdDay"), toDate));
        }
        
        q.where(predicates.toArray(new Predicate[]{}));            
                    
        q.groupBy(b.function("MONTH",Integer.class, rootM.get("date")),
        b.function("YEAR",Integer.class, rootM.get("date"))); 
        
        Query query = session.createQuery(q);    
        return query.getResultList();
    }
}
