/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Medical;
import com.wpk.repository.MedicalRepository;

import com.wpk.service.MedicalService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class MedicalServiceImpl implements MedicalService{
    @Autowired
    private MedicalRepository medicalRepository;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<Medical> getMedicals() {
        return medicalRepository.getMedicals();
    }

    @Override
    public Medical getMedicalByID(int id) {
        return medicalRepository.getMedicalByID(id);
    }

    @Override
    public boolean addOrUpdate(Medical m) {
        if(!m.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","medical"));
            m.setImage((String) r.get("secure_url"));
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
       
        return this.medicalRepository.addOrUpdate(m);
    }
    @Override
    public boolean removeMedical(int i) {
        return this.medicalRepository.removeMedical(i);
    }

    @Override
    public List<Medical> getMedicals(String name, String pageQuan, int pageNum) {
        return this.medicalRepository.getMedicals(name, pageQuan, pageNum);
    }

    @Override
    public long countMedical(String name) {
        return this.medicalRepository.countMedical(name);
    }
}
