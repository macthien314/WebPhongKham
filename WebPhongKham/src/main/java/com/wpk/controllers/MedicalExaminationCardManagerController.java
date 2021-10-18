/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.service.MedicalExaminationCardService;
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
public class MedicalExaminationCardManagerController {
     @Autowired
    private MedicalExaminationCardService medicalExaminationCardsService;
    @Autowired
    private WebAppValidator medicalExaminationCardValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(medicalExaminationCardValidator);
   }
    @GetMapping("/admin/medicalexaminationcard-manager")
    public String MedicalExaminationCardManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("medicalexaminationcard", new MedicalExaminationCard());
        model.addAttribute("medicalexaminationcards", this.medicalExaminationCardsService.getMedicalExaminationCards());
        return "medicalexaminationcard-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/medicalexaminationcard-manager/add-medicalexaminationcard")
    private String addMedicalShow(Model model){
        model.addAttribute("medicalexaminationcard", new MedicalExaminationCard());
        return "add-medicalexaminationcard";
   }
    @PostMapping("/admin/medicalexaminationcard-manager/add-medicalexaminationcard")
    private String addMedicalExaminationCardProcess(Model model, @ModelAttribute(value = "medicalexaminationcard")@Valid MedicalExaminationCard m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.medicalExaminationCardsService.addOrUpdate(m)==true)
                    return "redirect:/admin/medicalexaminationcard-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-medicalexaminationcards";
    }
    
}
