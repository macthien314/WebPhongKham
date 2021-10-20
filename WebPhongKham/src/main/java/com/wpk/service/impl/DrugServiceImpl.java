/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Drug;
import com.wpk.repository.DrugRepository;
import com.wpk.service.DrugService;
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
public class DrugServiceImpl implements DrugService{
    @Autowired
    private DrugRepository drugRepository;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<Drug> getDrugs() {
        return drugRepository.getDrugs();
    }

    @Override
    public Drug getDrugByID(int id) {
        return drugRepository.getDrugByID(id);
    }

    @Override
    public boolean addOrUpdate(Drug m) {
     
        return this.drugRepository.addOrUpdate(m);
    }}
