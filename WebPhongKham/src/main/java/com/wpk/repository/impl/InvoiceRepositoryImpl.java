/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;
import com.wpk.pojos.Invoice;
import com.wpk.repository.InvoiceRepository;
import java.util.List;
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
public class InvoiceRepositoryImpl implements InvoiceRepository {
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<Invoice> getInvoices() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Invoice");
        return q.getResultList();
    }

    @Override
    public Invoice getInvoiceByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(Invoice.class, id);
    }

    @Override
    public boolean addOrUpdate(Invoice m) {
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
    public boolean removeInvoice(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        Invoice m = this.getInvoiceByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
}

  

