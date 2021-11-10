/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.DrugCart;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.pojos.User;
import com.wpk.repository.ServiceInvoiceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
 * @author macth
 */
@Repository
@Transactional
public class ServiceInvoiceRepositoryImpl implements ServiceInvoiceRepository{
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<ServiceInvoice> getServiceInvoice() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From ServiceInvoice");
        return q.getResultList();
    }

    @Override
    public ServiceInvoice getServiceInvoiceByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(ServiceInvoice.class, id);
    }

    @Override
    public boolean addOrUpdate(ServiceInvoice m) {
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
    public boolean removeServiceInvoice(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        ServiceInvoice m = this.getServiceInvoiceByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }

    @Override
    public List<ServiceInvoice> getServiceInvoicesByPatient(int patientiID) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ServiceInvoice> query = builder.createQuery(ServiceInvoice.class);
        Root root = query.from(ServiceInvoice.class);
        query = query.select(root);
  
        Predicate p = builder.equal(root.get("patient").get("id").as(Integer.class),patientiID);
       
        query = query.where(p);
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    
}
