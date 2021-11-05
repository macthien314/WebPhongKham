/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import java.util.List;
import java.util.Map;
/**
 *
 * @author macth
 */
public interface PrescriptionRepository {
    List<Prescription> getPrescriptions();
     Prescription getPrescriptionByID(int id);
     boolean addOrUpdate(Prescription m); 
     
     boolean addReceipt(Map<String, PrescriptionDrug> m, int id); 
}
