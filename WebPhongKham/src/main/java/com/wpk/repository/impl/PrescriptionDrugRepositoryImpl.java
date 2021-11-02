/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.repository.PrescriptionDrugRepository;
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
public class PrescriptionDrugRepositoryImpl implements PrescriptionDrugRepository{
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<PrescriptionDrug> getPrescriptionDrugs() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From PrescriptionDrug");
        return q.getResultList();
    }

    @Override
    public PrescriptionDrug getPrescriptionDrugByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(PrescriptionDrug.class, id);
    }

    @Override
    public boolean addOrUpdate(PrescriptionDrug m) {
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
    public boolean removePrescriptionDrug(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        PrescriptionDrug m = this.getPrescriptionDrugByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }

  
}
