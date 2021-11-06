/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Nurse;
import com.wpk.repository.NurseRepository;

import com.wpk.service.NurseService;
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
public class NurseServiceImpl implements NurseService{
    @Autowired
    private NurseRepository nurseRepository;
    @Autowired
    private Cloudinary cloudinary; 
  @Override
    public List<Nurse> getNurses() {
        return nurseRepository.getNurses();
    }

    @Override
    public Nurse getNurseByID(int id) {
        return nurseRepository.getNurseByID(id);
    }

    @Override
    public boolean addOrUpdate(Nurse m) {
        if(!m.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","nurse"));
            m.setImage((String) r.get("secure_url"));
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
        return this.nurseRepository.addOrUpdate(m);
    }
    @Override
    public boolean removeNurse(int i) {
        return this.nurseRepository.removeNurse(i);
    }

    @Override
    public Nurse findNurseByUsername(String string) {
        return this.nurseRepository.findNurseByUsername(string);
    }

    @Override
    public Long countNurse(String firstName, String lastName, String medID, String account) {
        return this.nurseRepository.countNurse(firstName, lastName, medID, account);
    }

    @Override
    public List<Nurse> getNurses(String firstName, String lastName, String medID, String account, String pageQuan, int page) {
        return this.nurseRepository.getNurses(firstName, lastName, medID, account,pageQuan, page);    }

  
}

