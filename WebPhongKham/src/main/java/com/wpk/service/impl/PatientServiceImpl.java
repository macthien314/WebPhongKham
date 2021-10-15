/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Patient;
import com.wpk.repository.PatientRepository;
import com.wpk.service.PatientService;
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
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private Cloudinary cloudinary; 

    @Override
    public List<Patient> getPatients() {
           return patientRepository.getPatients();
    }

    @Override
    public boolean addOrUpdate(Patient d) {
        if(!d.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(d.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","patient"));
            d.setImage((String) r.get("secure_url"));
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
        return this.patientRepository.addOrUpdate(d);
    }

    @Override
    public Patient getPatientByID(int id) {
          return patientRepository.getPatientByID(id);
    }
}
