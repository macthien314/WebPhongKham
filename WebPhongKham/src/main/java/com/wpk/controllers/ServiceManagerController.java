/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.Services;
import com.wpk.service.ServicesService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class ServiceManagerController {
     @Autowired
    private ServicesService servicesService;
   @Autowired
    private WebAppValidator servicesValidator;
   @InitBinder
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(servicesValidator);
   }
    @RequestMapping("/admin/services-manager")
    public String ServiceManager(Model model, @RequestParam(required = false)Map<String, String> params)
    {   
        
        String quantity = params.getOrDefault("quantity", "10");
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("services", this.servicesService.getServices());
        return "services-manager";
    }
    //chuc nang them dịch vụ
    @GetMapping("/admin/services-manager/add-service")
    private String addServiceShow(Model model){
        model.addAttribute("service", new Services());
        return "add-services";
   }
    @PostMapping("/admin/services-manager/add-service")
    private String addDoctorProcess(Model model, @ModelAttribute(value = "service")@Valid Services s, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.servicesService.addOrUpdate(s)==true)
                    return "redirect:/admin/services-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-services";
    }
}
