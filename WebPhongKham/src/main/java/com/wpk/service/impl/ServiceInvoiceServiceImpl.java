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
import java.util.List;
import java.util.Map;
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
        if(!m.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","serviceinvoice"));
        
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
        return this.serviceInvoiceRepository.addOrUpdate(m);
    } 

    @Override
    public ServiceInvoice getServiceInvoiceByID(int id) {
         return serviceInvoiceRepository.getServiceInvoiceByID(id);
    }
}
