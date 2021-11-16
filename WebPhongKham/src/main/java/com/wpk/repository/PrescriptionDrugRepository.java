/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;

import com.wpk.pojos.PrescriptionDrug;
import java.util.List;

/**
 *
 * @author macth
 */
public interface PrescriptionDrugRepository {
    List<PrescriptionDrug> getPrescriptionDrugs();
    PrescriptionDrug getPrescriptionDrugByID(int id); 
    boolean addOrUpdate(PrescriptionDrug m);   
    boolean removePrescriptionDrug(int id); 
    List<PrescriptionDrug> getPrescriptionDrugsByPres(int presID);
}
