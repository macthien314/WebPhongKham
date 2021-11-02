/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

/**
 *
 * @author macth
 */

import com.wpk.pojos.PrescriptionDrug;
import com.wpk.service.PrescriptionDrugService;
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
public class PrescriptionDrugManagerController {
     @Autowired
    private PrescriptionDrugService prescriptionDrugService;
    @Autowired
    private WebAppValidator prescriptionDrugValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(prescriptionDrugValidator);
   }
    @GetMapping("/admin/prescriptiondrug-manager")
    public String PrescriptionDrugManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("prescriptiondrug", new PrescriptionDrug());
        model.addAttribute("prescriptiondrugs", this.prescriptionDrugService.getPrescriptionDrugs());
        return "prescriptiondrug-manager";
    }
    
    //chuc nang them chuyen khoa
    @GetMapping("/admin/prescriptiondrug-manager/add-prescriptiondrug")
    private String addPrescriptionDrugShow(Model model){
        model.addAttribute("prescriptiondrug", new PrescriptionDrug());
        return "add-prescriptiondrug";
   }
    @PostMapping("/admin/prescriptiondrug-manager/add-prescriptiondrug")
    private String addPrescriptionDrugProcess(Model model, @ModelAttribute(value = "prescriptiondrug")@Valid PrescriptionDrug m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.prescriptionDrugService.addOrUpdate(m)==true)
                    return "redirect:/admin/prescriptiondrug-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-prescriptiondrug";
    }
    
    
      @GetMapping("/admin/prescriptiondrug-manager/edit-prescriptiondrug/{prescriptiondrugID}")
    public String editPrescriptionDrugIDShow(Model model,@PathVariable(value ="prescriptiondrugID") int prescriptiondrugID){
        PrescriptionDrug m = this.prescriptionDrugService.getPrescriptionDrugByID(prescriptiondrugID);
        model.addAttribute("prescriptiondrug", m);
        return "edit-prescriptiondrug";
    }
    @PostMapping("/admin/prescriptiondrug-manager/edit-prescriptiondrug")
    public String editPrescriptionDrugProsses(Model model, @ModelAttribute(value = "prescriptiondrug")@Valid PrescriptionDrug m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.prescriptionDrugService.addOrUpdate(m)==true)
                    return "redirect:/admin/prescriptiondrug-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/prescriptiondrug-manager/edit-prescriptiondrug/{"+m.getId().toString()+"}" ;
    }
    
    
     @RequestMapping(value="/admin/prescriptiondrug-manager/delete-prescriptiondrug/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deletePrescriptionDrug(Model model,@PathVariable(value ="id") int id){
        
        if(this.prescriptionDrugService.removePrescriptionDrug(id)){
            return "redirect:/admin/prescriptiondrug-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/prescriptiondrug-manager";
    }
     @GetMapping("/phieu-kham/{prescriptiondrugid}")
    public String prescriptiondrugs(Model model,@PathVariable(value ="prescriptiondrugid") int prescriptiondrugid){
        model.addAttribute("prescriptiondrugs", this.prescriptionDrugService.getPrescriptionDrugByID(prescriptiondrugid));
        return "prescriptiondrug-detail";
    }
}
  

