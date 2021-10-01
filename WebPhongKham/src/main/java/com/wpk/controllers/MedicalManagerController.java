/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Medical;
import com.wpk.pojos.Slide;
import com.wpk.service.MedicalService;
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
 * @author Admin
 */
@Controller
public class MedicalManagerController {
    @Autowired
    private MedicalService medicalService;
    @Autowired
    private WebAppValidator medicalValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(medicalValidator);
   }
    @GetMapping("/admin/medical-manager")
    public String MedicalManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("medical", new Medical());
        model.addAttribute("medicals", this.medicalService.getMedicals());
        return "medical-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/medical-manager/add-medical")
    private String addMedicalShow(Model model){
        model.addAttribute("medical", new Medical());
        return "add-medical";
   }
    @PostMapping("/admin/medical-manager/add-medical")
    private String addMedicalProcess(Model model, @ModelAttribute(value = "medical")@Valid Medical m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.medicalService.addOrUpdate(m)==true)
                    return "redirect:/admin/medical-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-medicals";
    }
    
}
