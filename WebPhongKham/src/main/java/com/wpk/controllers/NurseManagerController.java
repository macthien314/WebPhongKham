/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Medical;
import com.wpk.pojos.Nurse;
import com.wpk.service.MedicalService;
import com.wpk.service.NurseService;
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
public class NurseManagerController {
    @Autowired
    private NurseService nurseService;
    @Autowired
    private MedicalService medicalService;
    @Autowired
    private WebAppValidator nurseValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(nurseValidator);
   }
    @GetMapping("/admin/nurse-manager")
    public String NurseManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("nurse", new Nurse());
        model.addAttribute("nurses", this.nurseService.getNurses());
        return "nurse-manager";
    }
    
     //chuc nang them chuyen khoa
    @GetMapping("/admin/nurse-manager/add-nurse")
    private String addNurseShow(Model model){
        model.addAttribute("medi",medicalService.getMedicals());
        model.addAttribute("nurse", new Nurse());
        return "add-nurse";
   }
    @PostMapping("/admin/nurse-manager/add-nurse")
    private String addNurseProcess(Model model, @ModelAttribute(value = "nurse")@Valid Nurse n, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.nurseService.addOrUpdate(n)==true)
                    return "redirect:/admin/nurse-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-nurse";
    }
}
