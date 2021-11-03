/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Patient;
import com.wpk.service.PatientService;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class NursePatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private WebAppValidator patientValidator;
     @InitBinder
     public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(patientValidator);
   }
    @GetMapping("/nurse/patient-manager")
    public String PatientManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", this.patientService.getPatients());
        return "nursepatient-manager";
    }
    
     
}
