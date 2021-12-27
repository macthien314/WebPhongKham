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
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        String name = params.getOrDefault("name", "");
        
    
        String pageQuan = params.getOrDefault("pagequan", "4");
        
        if(pageQuan.isEmpty()){
            pageQuan = "4";
        }
        else if(!pageQuan.equals("all"))
                if(pageQuan.contains("a") || pageQuan.contains("l"))
                    pageQuan = "all";
                else if(Integer.parseInt(pageQuan) <= 0)
                    pageQuan = "4";
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("medicals", this.medicalService.getMedicals(name, pageQuan, page));
        
        model.addAttribute("count", this.medicalService.countMedical(name));
        
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("name", name);
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
        return "add-medical";
    }
    //chuc nang xoa slide
     @RequestMapping(value="/admin/medical-manager/delete-medical/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteMedical(Model model,@PathVariable(value ="id") int id){
        try{
        if(this.medicalService.removeMedical(id)){
            return "redirect:/admin/medical-manager";
        }
        else model.addAttribute("err","Something wrong");
        }catch(Exception e){
        }
        return "redirect:/admin/medical-manager";
    }
    
    //chuc nang sua chuyen khoa
    //ch?c nang s?a slide
    @GetMapping("/admin/medical-manager/edit-medical/{medicalID}")
    public String editMedicalShow(Model model,@PathVariable(value ="medicalID") int medicalID){
        Medical m = this.medicalService.getMedicalByID(medicalID);
        if(model.getAttribute("medical") == null)
        model.addAttribute("medical", m);
        return "edit-medical";
    }
    @PostMapping("/admin/medical-manager/edit-medical/{medicalID}")
    public String editMedicalProsses(Model model,@PathVariable(value ="medicalID") int medicalID, @ModelAttribute(value = "medical")@Valid Medical m, BindingResult result
            ,RedirectAttributes attr, HttpSession session){
        
        if(!result.hasErrors())
        {   
            if(this.medicalService.addOrUpdate(m)==true)
                    return "redirect:/admin/medical-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        attr.addFlashAttribute("org.springframework.validation.BindingResult.medical", result);
        attr.addFlashAttribute("medical",m);
        return "redirect:/admin/medical-manager/edit-medical/" + medicalID ;
    }
}
