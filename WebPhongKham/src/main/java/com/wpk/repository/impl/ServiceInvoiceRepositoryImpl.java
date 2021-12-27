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
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;

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
    //lấy danh sách hóa đơn dịch vụ
    @Override
    public List<ServiceInvoice> getServiceInvoicesByPatient(int patientiID,Date fromDate,Date toDate,String pageQuan,int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ServiceInvoice> query = builder.createQuery(ServiceInvoice.class);
        Root root = query.from(ServiceInvoice.class);
        query = query.select(root);
      
       List<Predicate> predicates = new ArrayList<Predicate>();
      
        if(patientiID != 0){
            predicates.add(builder.equal(root.get("patient").get("id").as(Integer.class), patientiID));
        }
         if(fromDate != null)
        {
           predicates.add(builder.greaterThanOrEqualTo(root.get("createdDate"), fromDate));
        }
        if(toDate != null)
        {
           predicates.add(builder.lessThanOrEqualTo(root.get("createdDate"), toDate));
        }
       
    
      
        query = query.where(builder.and(predicates.toArray(new Predicate[] {})));
         List<Order> orderList = new ArrayList();
        orderList.add(builder.desc(root.get("id").as(Integer.class)));
        query.orderBy(orderList);
        
        Query q = session.createQuery(query);
       
        if(pageQuan != null && !pageQuan.isEmpty() && !pageQuan.equals("all") ){
            int max = Integer.parseInt(pageQuan);
            q.setMaxResults(max);
            q.setFirstResult((page- 1) * max);
        }
        
        return q.getResultList();
    }
    @Override
    public long countServiceInvoicesByPatient(int patientid,Date fromDate,Date toDate){
        Session session = sessionFactory.getObject().getCurrentSession();
        String query="SELECT COUNT(*) FROM  ServiceInvoice p where p.id is not null";
        if(patientid != 0){
             query = query + " and p.patient.id = :id";
        }
        if(fromDate != null)
            query = query + " and p.createdDate >= :fromDate";
        if(toDate != null)
            query = query + " and p.createdDate <= :toDate";
        
        Query q = session.createQuery(query);    
        if(patientid != 0)
           q.setParameter("id",patientid );
        if(fromDate != null)
            q.setParameter("fromDate",fromDate );
        if(toDate != null)
            q.setParameter("toDate",toDate );
    
     
        return Long.parseLong(q.getSingleResult().toString());
    }

}
