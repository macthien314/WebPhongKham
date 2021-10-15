/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author macth
 */
@Controller
public class PatientController {
     @Autowired
    private PatientService patientService;
    @GetMapping("/benh-nhan/{patientid}")
    public String patient(Model model,@PathVariable(value ="patientid") int patientid){
        model.addAttribute("doctor", this.patientService.getPatientByID(patientid));
        return "patient-detail";
    }
}
