/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;
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
public interface PrescriptionRepository {
    List<Prescription> getPrescriptions();
    Prescription getPrescriptionByID(int id);
    boolean addOrUpdate(Prescription m); 
    boolean removePrescription(int id); 
    boolean addReceipt(Map<String, PrescriptionDrug> m, int id); 
    
    List<Prescription> getPrescriptions(String invoiceID, String patientID, String pageQuan, int page);
    long countPresciptions(String invoiceID, String patientID);
    //chức năng thêm toa thuốc
    boolean addPrescription(Prescription p,MedicalExaminationCard m, Map<Integer,DrugCart> map);
}
