/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Doctor;
import com.wpk.service.DoctorService;
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
public class DoctorManagerController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private WebAppValidator doctorValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(doctorValidator);
   }
    @GetMapping("/admin/doctor-manager")
    public String DoctorManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("doctors", this.doctorService.getDoctor());
        return "doctor-manager";
    }
    //chuc nang them bac si
    @GetMapping("/admin/doctor-manager/add-doctor")
    private String addDoctorShow(Model model){
        model.addAttribute("doctor", new Doctor());
        return "add-doctor";
   }
    @PostMapping("/admin/doctor-manager/add-doctor")
    private String addDoctorProcess(Model model, @ModelAttribute(value = "doctor")@Valid Doctor m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.doctorService.addOrUpdate(m)==true)
                    return "redirect:/admin/doctor-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-doctor";
    }
    
    //chuc nang xoa bac si
     @RequestMapping(value="/admin/doctor-manager/delete-doctor/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteDoctor(Model model,@PathVariable(value ="id") int id){
        
        if(this.doctorService.removeDoctor(id)){
            return "redirect:/admin/doctor-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/doctor-manager";
    }
    
    //chuc nang sua y tá
    
    @GetMapping("/admin/doctor-manager/edit-doctor/{doctorID}")
    public String editDoctorShow(Model model,@PathVariable(value ="doctorID") int doctorID){
        Doctor m = this.doctorService.getDoctorByID(doctorID);
        model.addAttribute("doctor", m);
        return "edit-doctor";
    }
    @PostMapping("/admin/doctor-manager/edit-doctor")
    public String editDoctorProsses(Model model, @ModelAttribute(value = "doctor")@Valid Doctor m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.doctorService.addOrUpdate(m)==true)
                    return "redirect:/admin/doctor-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/doctor-manager/edit-doctor/{"+m.getId().toString()+"}" ;
    }
}
