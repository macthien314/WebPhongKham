/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.DrugCart;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import java.util.List;
import java.util.Map;

/**
 *
 * @author macth
 */
public interface PrescriptionDrugService {
    List<PrescriptionDrug> getPrescriptionDrugs();
    PrescriptionDrug getPrescriptionDrugByID(int id);
    boolean addOrUpdate(PrescriptionDrug m);
    boolean removePrescriptionDrug(int id); 

    List<PrescriptionDrug> getPrescriptionDrugsByPres(int presID);
}
