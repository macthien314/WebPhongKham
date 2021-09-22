/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.wpk.pojos.Medical;
import com.wpk.repository.MedicalRepository;

import com.wpk.service.MedicalService;
import java.util.List;
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
    @Override
    public List<Medical> getMedicals() {
        return medicalRepository.getMedicals();
    }
    
}
