/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository.impl;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.User;
import com.wpk.repository.MedicalExaminationCardRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang.time.DateUtils;
import static org.eclipse.persistence.expressions.ExpressionOperator.today;
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
    public List<MedicalExaminationCard> getTodayMedCard(int doctorID){
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MedicalExaminationCard> query = builder.createQuery(MedicalExaminationCard.class);
        Root root = query.from(MedicalExaminationCard.class);
        
        query = query.select(root);
        Date today = new Date();
        Date todayMorning = DateUtils.truncate(today, Calendar.DATE);
        Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
        Predicate p1 = builder.equal(root.get("doctor").get("id").as(Integer.class), doctorID);
        Predicate p2 = builder.between(root.get("date").as(Date.class), todayMorning, todayEvening);
        
          
        query = query.where(builder.and(p1, p2));
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }
    @Override
    public int countTodayMedCard(int doctorID){
        Session session = sessionFactory.getObject().getCurrentSession();
//        Date today = new Date();
//        Date todayMorning = DateUtils.truncate(today, Calendar.DATE);
//        Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
        String query="SELECT COUNT(*) FROM MedicalExaminationCard m where m.doctor.id = :id "
                + "and year(m.date) = year(current_date())"
                + "and month(m.date) = month(current_date())"
                +"and day(m.date) = day(current_date())";
      
        Query q = session.createQuery(query);
        q.setParameter("id", doctorID);
        
        
     
        return Integer.parseInt(q.getSingleResult().toString());
    }
}
