/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;

import com.wpk.pojos.Nurse;
import java.util.List;

/**
 *
 * @author macth
 */
public interface NurseRepository {
     List<Nurse> getNurses();
     Nurse getNurseByID(int id);
     boolean addOrUpdate(Nurse m);
}
