/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.repository.MedicalExaminationCardRepository;
import com.wpk.service.MedicalExaminationCardService;
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
public class MedicalExaminationCardServiceImpl implements MedicalExaminationCardService {
   @Autowired
    private MedicalExaminationCardRepository medicalExaminationCardRepository;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<MedicalExaminationCard> getMedicalExaminationCards() {
        return medicalExaminationCardRepository.getMedicalExaminationCard();
    }

      @Override
    public boolean addOrUpdate(MedicalExaminationCard m) {
        return this.medicalExaminationCardRepository.addOrUpdate(m);
    } 

    @Override
    public MedicalExaminationCard getMedicalExaminationCardByID(int id) {
         return medicalExaminationCardRepository.getMedicalExaminationCardByID(id);
    }
    
     @Override
    public boolean removeMedicalExaminationCard(int i) {
        return this.medicalExaminationCardRepository.removeMedicalExaminationCard(i);
    }
}
