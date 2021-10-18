/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.repository.ServiceInvoiceRepository;
import java.util.List;
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
            session.save(m);
            return true;
        }
        catch(Exception e){
            System.err.println("==ADD PRODUCT===" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
