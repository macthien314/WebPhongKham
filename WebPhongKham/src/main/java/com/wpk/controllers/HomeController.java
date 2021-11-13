/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.service.DoctorService;
import com.wpk.service.DrugService;
import com.wpk.service.InvoiceService;
import com.wpk.service.MedicalService;
import com.wpk.service.NurseService;
import com.wpk.service.PatientService;
import com.wpk.service.PrescriptionService;
import com.wpk.service.ServicesService;
import com.wpk.service.SlideService;
import com.wpk.service.UserService;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macth
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private MedicalService medicalService;
    @Autowired
    private SlideService slideService;
    @Autowired
    private DoctorService doctorService;
      @Autowired
    private ServicesService servicesService;
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("medicals", this.medicalService.getMedicals());
        model.addAttribute("showSlide", this.slideService.getSlides("", "true", "5", 1));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("services", this.servicesService.getServices());
        model.addAttribute("doctors", this.doctorService.getDoctors("", "", "all", "all", "all", 0));

    }
    
  

   
    
    
   
    
    
  
 
   
    
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("name", "Thien");
        return "index";
    }
    
}
