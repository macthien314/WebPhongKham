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
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("medicals", this.medicalService.getMedicals());
        model.addAttribute("showSlide", this.slideService.getSlides("", "true", "5", 1));
    }
    
     @Autowired
    private DoctorService doctorService;
    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session, String firstName, String lastName, String medID, String account, String pageQuan){
        model.addAttribute("doctors", this.doctorService.getDoctors(firstName, lastName, medID, account, pageQuan, 0));
    }
    
      @Autowired
    private NurseService nurseService;
    @ModelAttribute
    public void commonAttrsss(Model model, HttpSession session){
        model.addAttribute("nurses", this.nurseService.getNurses());
    }
    
    @Autowired
    private DrugService drugService;
    @ModelAttribute
    public void commonAttrss(Model model, HttpSession session){
        model.addAttribute("drugs", this.drugService.getDrugs());
    }
 
    
       @Autowired
    private PrescriptionService prescriptionService;
    @ModelAttribute
    public void commonAttrsssss(Model model, HttpSession session){
        model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions());
    }
    
       @Autowired
    private InvoiceService invoiceService;
    @ModelAttribute
    public void commonAttrssssss(Model model, HttpSession session){
        model.addAttribute("invoices", this.invoiceService.getInvoices());
    }
    
    
    @Autowired
    private ServicesService servicesService;
    @ModelAttribute
    public void commonAttrssss(Model model, HttpSession session){
        model.addAttribute("services", this.servicesService.getServices());
    }
    
   
    
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("name", "Thien");
        return "index";
    }
    
}
