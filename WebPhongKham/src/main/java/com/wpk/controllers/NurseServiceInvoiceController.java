/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.pojos.Patient;
import com.wpk.pojos.ServiceInvoice;

import com.wpk.service.PatientService;
import com.wpk.service.ServiceInvoiceService;
import com.wpk.service.ServicesService;
import com.wpk.service.UserService;
import com.wpk.validator.WebAppValidator;
import java.security.Principal;
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

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller

public class NurseServiceInvoiceController {
    @Autowired
    private PatientService patientService;
    
   @Autowired
   private UserService userDetailsService;
    @Autowired
    private ServiceInvoiceService serviceInvoiceService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private WebAppValidator serviceInvoiceValidator;
     @InitBinder
     public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(serviceInvoiceValidator);
   }
    @GetMapping("/nurse/patient-serviceinvoice")
    public String PatientManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", this.patientService.getPatients());
        return "patient-serviceinvoice";
    }
    @GetMapping("/nurse/patient-serviceinvoice/{patientid}")
    public String serviceInvoiceManager(Principal principal,Model model,@PathVariable(value ="patientid") int patientid){
        model.addAttribute("patient",this.patientService.getPatientByID(patientid));
        model.addAttribute("serviceinvoices", this.serviceInvoiceService.getServiceInvoicesByPatient(patientid));
        if(model.getAttribute("serviceinvoice") == null)
        model.addAttribute("serviceinvoice",new ServiceInvoice());
        model.addAttribute("services", this.servicesService.getServices());
        String name = principal.getName();
        model.addAttribute("nurse",userDetailsService.getUser(name).get(0).getNurse());
        return "serviceinvoice-list";
    }
    @PostMapping("/nurse/patient-serviceinvoice/{patientid}/create")
    private String addServiceInvoiceProcess(Principal principal,Model model,@PathVariable(value ="patientid") int patientid, @ModelAttribute(value = "serviceinvoice")@Valid ServiceInvoice m, BindingResult result
            ,RedirectAttributes attr, HttpSession session){
   
        if(!result.hasErrors())
        {   
            String name = principal.getName();
            m.setPatient(this.patientService.getPatientByID(patientid));
            m.setNurse(userDetailsService.getUser(name).get(0).getNurse());
            m.setFee(this.servicesService.getServicesByID(m.getService().getId()).getFee());
        
            if(this.serviceInvoiceService.addOrUpdate(m)==true){
                attr.addFlashAttribute("susscess", "s");
                return"redirect:/nurse/patient-serviceinvoice/" + patientid;
            }
            else{
                model.addAttribute("err","Something wrong");
                
            }
        }
        attr.addFlashAttribute("wrong", "");
        attr.addFlashAttribute("org.springframework.validation.BindingResult.serviceinvoice", result);
        attr.addFlashAttribute("serviceinvoice", m);
        return "redirect:/nurse/patient-serviceinvoice/" + patientid ;
    }
}
