/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.repository.MedicalExaminationCardRepository;
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
public class MedicalExaminationCardRepositoryImpl implements MedicalExaminationCardRepository{
     @Autowired
    private LocalSessionFactoryBean sessionFactory;
      
      @Override
    public List<MedicalExaminationCard> getMedicalExaminationCard() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From MedicalExaminationCard");
        return q.getResultList();
    }

    @Override
    public MedicalExaminationCard getMedicalExaminationCardByID(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(MedicalExaminationCard.class, id);
    }

    @Override
    public boolean addOrUpdate(MedicalExaminationCard m) {
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
    public boolean removeMedicalExaminationCard(int id) {
       Session session = sessionFactory.getObject().getCurrentSession();
        MedicalExaminationCard m = this.getMedicalExaminationCardByID(id);
        try{
            session.delete(m);
            return true;
        }
        catch(Exception e){
        
        }
        return false;
    }
}
