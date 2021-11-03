/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Medical;
import com.wpk.pojos.Patient;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.pojos.User;
import com.wpk.service.PatientService;
import com.wpk.service.ServiceInvoiceService;
import com.wpk.service.ServicesService;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @RequestMapping("/nurse/patient-serviceinvoice/{patientid}")
    public String serviceInvoiceManager(Model model,@PathVariable(value ="patientid") int patientid){
        model.addAttribute("patient",this.patientService.getPatientByID(patientid));
        model.addAttribute("serviceinvoices", this.serviceInvoiceService.getServiceInvoicesByPatient(patientid));
        model.addAttribute("serviceinvoice",new ServiceInvoice());
        model.addAttribute("services", this.servicesService.getServices());
        
        return "serviceinvoice-list";
    }
    @PostMapping("/nurse/patient-serviceinvoice/{patientid}")
    private String addServiceInvoiceProcess(Model model,@PathVariable(value ="patientid") int patientid, @ModelAttribute(value = "serviceinvoice")@Valid ServiceInvoice m, BindingResult result
            ){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        m.setNurse(((User)principal).getNurse());
        if(!result.hasErrors())
        {   
            
            m.setFee(m.getService().getFee());
        
            if(this.serviceInvoiceService.addOrUpdate(m)==true)
                   return"redirect:/nurse/patient-serviceinvoice/" + patientid;
            else{
                model.addAttribute("err","Something wrong");
                model.addAttribute("patient",this.patientService.getPatientByID(patientid));
                model.addAttribute("serviceinvoices", this.serviceInvoiceService.getServiceInvoicesByPatient(patientid));
              
                model.addAttribute("services", this.servicesService.getServices());
            }
        }
        model.addAttribute("patient",this.patientService.getPatientByID(patientid));
        model.addAttribute("serviceinvoices", this.serviceInvoiceService.getServiceInvoicesByPatient(patientid));
        model.addAttribute("services", this.servicesService.getServices());
        return "serviceinvoice-list" ;
    }
}
