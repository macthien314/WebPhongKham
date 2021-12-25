/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Drug;
import com.wpk.pojos.Services;
import java.util.List;

/**
 *
 * @author macth
 */
public interface DrugService {
     List<Drug> getDrugs();
     Drug getDrugByID(int id);
     boolean addOrUpdate(Drug m);
     boolean removeDrug(int id);
     
     List<Drug> getDrugs(String name, String pageQuan, int pageNum);
     long countDrug(String name);

    List<Drug> getUnexpiredDrug();
     
}
