/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Doctor;
import com.wpk.repository.DoctorRepository;
import com.wpk.repository.MedicalExaminationCardRepository;
import com.wpk.service.DoctorService;
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
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MedicalExaminationCardRepository medicalExaminationCardRepository;
    @Autowired
    private Cloudinary cloudinary; 


    @Override
    public boolean addOrUpdate(Doctor d) {
        if(!d.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(d.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","doctor"));
            d.setImage((String) r.get("secure_url"));
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
        return this.doctorRepository.addOrUpdate(d);
    }

    @Override
    public Doctor getDoctorByID(int id) {
          return doctorRepository.getDoctorByID(id);
    }
    
    @Override
    public boolean removeDoctor(int i) {
        return this.doctorRepository.removeDoctor(i);
    }

    @Override
    public  List<Doctor> getDoctors(String firstName, String lastName, String medID, String account, String pageQuan, int page) {
        return this.doctorRepository.getDoctors(firstName, lastName, medID, account,pageQuan, page);
    }

    @Override
    public long countDoctor(String firstName, String lastName, String medID, String account) {
        return this.doctorRepository.countDoctor(firstName, lastName, medID, account);
    }

    @Override
    public List<Doctor> getDoctorsWithMedCount (String firstName, String lastName, String medID, String account, String pageQuan, int page) {
        List<Doctor> doctors = this.doctorRepository.getDoctors(firstName, lastName, medID, account,pageQuan, page);
        for(Doctor d:doctors){
            d.setMedCardCount(this.medicalExaminationCardRepository.countTodayMedCard(d.getId()));
        }
        return doctors;
    }    

  
}
