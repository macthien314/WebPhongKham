/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;

import com.wpk.pojos.Medical;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface MedicalRepository {
     List<Medical> getMedicals();
     Medical getMedicalByID(int id);
     boolean addOrUpdate(Medical m);
     boolean removeMedical(int id);
     List<Medical> getMedicals(String name, String pageQuan, int pageNum);
     long countMedical(String name);
}
