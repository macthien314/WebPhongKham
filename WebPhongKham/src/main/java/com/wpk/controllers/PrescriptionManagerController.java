/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.service.PrescriptionService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author macth
 */
@Controller
public class PrescriptionManagerController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private WebAppValidator prescriptionValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(prescriptionValidator);
   }
    @GetMapping("/admin/prescription-manager")
    public String PrescriptionManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions());
        return "prescription-manager";
    }
    
    //chuc nang them bac si
    @GetMapping("/admin/prescription-manager/add-prescription")
    private String addPrescriptionShow(Model model){
        model.addAttribute("prescription", new Prescription());
        return "add-prescription";
   }
    @PostMapping("/admin/prescription-manager/add-prescription")
    private String addPrescriptionProcess(Model model, @ModelAttribute(value = "prescription")@Valid Prescription m,Map<String, PrescriptionDrug> t, int id, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.prescriptionService.addReceipt(t, id)==true)
                    return "redirect:/admin/prescription-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-prescription";
    }
    
    
    //chuc nang xoa bac si
     @RequestMapping(value="/admin/prescription-manager/delete-prescription/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deletePrescription(Model model,@PathVariable(value ="id") int id){
        
        if(this.prescriptionService.removePrescription(id)){
            return "redirect:/admin/prescription-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/prescription-manager";
    }
    
    //chuc nang sua y tá
    
    @GetMapping("/admin/prescription-manager/edit-prescription/{prescriptionID}")
    public String editPatientShow(Model model,@PathVariable(value ="prescriptionID") int prescriptionID){
        Prescription m = this.prescriptionService.getPrescriptionByID(prescriptionID);
        model.addAttribute("prescription", m);
        return "edit-prescription";
    }
    @PostMapping("/admin/prescription-manager/edit-prescription")
    public String editPrescriptionProsses(Model model, @ModelAttribute(value = "prescription")@Valid Prescription m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.prescriptionService.addOrUpdate(m)==true)
                    return "redirect:/admin/prescription-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/prescription-manager/edit-prescription/{"+m.getId().toString()+"}" ;
    }
}

