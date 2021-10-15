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
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author macth
 */
@Controller
public class PatientManagerController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private WebAppValidator patientValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(patientValidator);
   }
    @GetMapping("/admin/patient-manager")
    public String PatientManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", this.patientService.getPatients());
        return "patient-manager";
    }
    //chuc nang them bac si
    @GetMapping("/admin/patient-manager/add-patient")
    private String addPatientShow(Model model){
        model.addAttribute("patient", new Patient());
        return "add-patient";
   }
    @PostMapping("/admin/patient-manager/add-patient")
    private String addPatientProcess(Model model, @ModelAttribute(value = "patient")@Valid Patient m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.patientService.addOrUpdate(m)==true)
                    return "redirect:/admin/patient-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-patients";
    }
}
