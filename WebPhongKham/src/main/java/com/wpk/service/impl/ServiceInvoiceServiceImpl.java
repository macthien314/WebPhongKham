/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.repository.ServiceInvoiceRepository;
import com.wpk.service.ServiceInvoiceService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macth
 */
@Service
public class ServiceInvoiceServiceImpl implements ServiceInvoiceService {
    @Autowired
    private ServiceInvoiceRepository serviceInvoiceRepository;
  
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<ServiceInvoice> getServiceInvoices() {
        return serviceInvoiceRepository.getServiceInvoice();
    }

      @Override
    public boolean addOrUpdate(ServiceInvoice m) {
        m.setCreatedDate(new Date());
        return this.serviceInvoiceRepository.addOrUpdate(m);
    } 

    @Override
    public ServiceInvoice getServiceInvoiceByID(int id) {
         return serviceInvoiceRepository.getServiceInvoiceByID(id);
    }
      @Override
    public boolean removeServiceInvoice(int i) {
        return this.serviceInvoiceRepository.removeServiceInvoice(i);
    }

     @Override
    public List<ServiceInvoice> getServiceInvoicesByPatient(int patientiID,Date fromDate,Date toDate,String pageQuan,int page) {
        return this.getServiceInvoicesByPatient(patientiID, fromDate, toDate, pageQuan, page);
    }
    @Override
    public long countServiceInvoicesByPatient(int patientid,Date fromDate,Date toDate){
        return this.countServiceInvoicesByPatient(patientid, fromDate, toDate);
    }
    
}
