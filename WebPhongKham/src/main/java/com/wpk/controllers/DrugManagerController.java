/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;
import javax.validation.Valid;
import com.wpk.pojos.Drug;
import com.wpk.service.DrugService;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
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
public class DrugManagerController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private WebAppValidator drugValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(drugValidator);
   }
    @GetMapping("/admin/drug-manager")
    public String DrugManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("drug", new Drug());
        model.addAttribute("drugs", this.drugService.getDrugs());
        return "drug-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/drug-manager/add-drug")
    private String addDrugShow(Model model){
        model.addAttribute("drug", new Drug());
        return "add-drug";
   }
    @PostMapping("/admin/drug-manager/add-drug")
    private String addMedicalProcess(Model model, @ModelAttribute(value = "drug")@Valid Drug m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.drugService.addOrUpdate(m)==true)
                    return "redirect:/admin/drug-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-drugs";
    }
}
    