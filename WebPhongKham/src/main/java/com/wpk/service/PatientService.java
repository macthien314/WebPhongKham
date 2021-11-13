/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.Patient;
import java.util.List;

/**
 *
 * @author macth
 */
public interface PatientService {
    List<Patient> getPatients();
    Patient getPatientByID(int id);
    boolean addOrUpdate(Patient d);  
    boolean removePatient(int id);
    List<Patient> getPatients(String firstName, String lastName, String account, String pageQuan, int page);
    long countPatient(String firstName, String lastName, String account); 
}
