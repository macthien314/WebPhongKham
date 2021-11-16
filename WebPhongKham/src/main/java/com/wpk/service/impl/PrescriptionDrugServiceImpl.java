/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;


import com.wpk.pojos.DrugCart;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.repository.PrescriptionDrugRepository;
import com.wpk.service.PrescriptionDrugService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macth
 */
@Service
public class PrescriptionDrugServiceImpl implements PrescriptionDrugService {
   @Autowired
    private PrescriptionDrugRepository prescriptionDrugRepository;

    @Override
    public List<PrescriptionDrug> getPrescriptionDrugs() {
        return prescriptionDrugRepository.getPrescriptionDrugs();
    }

      @Override
    public boolean addOrUpdate(PrescriptionDrug m) {
        return this.prescriptionDrugRepository.addOrUpdate(m);
    } 

    @Override
    public PrescriptionDrug getPrescriptionDrugByID(int id) {
         return prescriptionDrugRepository.getPrescriptionDrugByID(id);
    }

    @Override
    public boolean removePrescriptionDrug(int id) {
        return this.prescriptionDrugRepository.removePrescriptionDrug(id);
    }

    @Override
    public List<PrescriptionDrug> getPrescriptionDrugsByPres(int i) {
        return this.prescriptionDrugRepository.getPrescriptionDrugsByPres(i);
    }
    
  
}
