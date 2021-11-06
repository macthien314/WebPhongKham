/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Nurse;
import java.util.List;

/**
 *
 * @author macth
 */
public interface NurseService {
      List<Nurse> getNurses();
    Nurse getNurseByID(int id);
     boolean addOrUpdate(Nurse m);
     boolean removeNurse(int id);

    Nurse findNurseByUsername(String name);

    Long countNurse(String firstName, String lastName, String medID, String account);

    List<Nurse> getNurses(String firstName, String lastName, String medID, String account, String pageQuan, int page);
     
}
