/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Services;
import com.wpk.repository.ServicesRepository;
import com.wpk.service.ServicesService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ServicesServiceImpl implements ServicesService{
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private Cloudinary cloudinary; 
    
 

   

    @Override
    public boolean addOrUpdate(Services s) {
        if(!s.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(s.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","service"));
            s.setImage((String) r.get("secure_url"));
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}

        return this.servicesRepository.addOrUpdate(s);
    }

    @Override
    public List<Services> getServices() {
         return servicesRepository.getServices();
    }

    @Override
    public Services getServicesByID(int id) {
        return this.servicesRepository.getServiceByID(id);
    }
    
     @Override
    public boolean removeServices(int i) {
        return this.servicesRepository.removeServices(i);
    }

    @Override
    public long countService(String name) {
        return this.servicesRepository.countService(name);
    }

    @Override
    public List<Services> getServices(String name, String pageQuan, int pageNum) {
        return this.servicesRepository.getServices(name, pageQuan, pageNum);
    }
}
