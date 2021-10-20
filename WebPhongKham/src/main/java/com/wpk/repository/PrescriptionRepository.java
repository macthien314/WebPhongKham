/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;
import com.wpk.pojos.Prescription;
import java.util.List;
/**
 *
 * @author macth
 */
public interface PrescriptionRepository {
    List<Prescription> getPrescriptions();
     Prescription getPrescriptionByID(int id);
     boolean addOrUpdate(Prescription m); 
}
