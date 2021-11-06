/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.repository.PrescriptionRepository;
import com.wpk.service.PrescriptionService;
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
public class PrescriptionServiceImpl implements PrescriptionService{
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private Cloudinary cloudinary; 

    @Override
    public List<Prescription> getPrescriptions() {
           return prescriptionRepository.getPrescriptions();
    }

    @Override
    public boolean addOrUpdate(Prescription d) {
       
        return this.prescriptionRepository.addOrUpdate(d);
    }

    @Override
    public Prescription getPrescriptionByID(int id) {
          return prescriptionRepository.getPrescriptionByID(id);
    }

    @Override
    public boolean addReceipt(Map<String, PrescriptionDrug> map, int id) {
         return this.prescriptionRepository.addReceipt(map, id);             
                 }  

    @Override
    public boolean removePrescription(int i) {
        return this.prescriptionRepository.removePrescription(i);
    }
}
