/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Invoice;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Patient;
import com.wpk.service.DoctorService;
import com.wpk.service.InvoiceService;
import com.wpk.service.PatientService;
import com.wpk.service.PrescriptionService;
import com.wpk.service.UserService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
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
public class NurseInvoiceController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
   @Autowired
   private UserService userDetailsService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private WebAppValidator invoiceValidator;
     @InitBinder
     public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(invoiceValidator);
   }
    @GetMapping("/nurse/patient-invoice")
    public String patientManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", this.patientService.getPatients());
        return "nurse-patient-invoice";
    }
    @GetMapping("/nurse/invoice/Prescription-list")
    public String prescriptionList(Model model,@RequestParam(required = false)Map<String, String> params){
        
        String presID = params.getOrDefault("id", "");
        if(!isNumeric(presID))
            presID = "";
        
        String patientID = params.getOrDefault("patientID", "");
        if(!isNumeric(patientID))
            patientID = "";
        
        //xử lý page
        String pageQuan = params.getOrDefault("pagequan", "10");
        if(pageQuan.isEmpty() ){
            pageQuan = "10";
        }
        else if(!pageQuan.equals("all"))
                if(!isNumeric(pageQuan))
                    pageQuan = "all";
                else if(Integer.parseInt(pageQuan) <= 0)
                    pageQuan = "10";
           
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        //kết thúc xử lý page
        model.addAttribute("prescriptions",this.prescriptionService.getPrescriptions(presID, patientID,pageQuan,page));
        model.addAttribute("count", this.prescriptionService.countPresciptions(presID, patientID));
        model.addAttribute("patients",this.patientService.getPatients()); 
        model.addAttribute("patientID", patientID);
        model.addAttribute("presID",presID);
        

        
        
        
        return "nurse-prescription";
    }
    @GetMapping("/nurse/invoice/prescription-list/{presid}")
    public String prescriptionInvoice(Principal principal,Model model,@PathVariable(value ="presid") int presID){
        
        model.addAttribute("invoices", this.invoiceService.getInvoicesByPres(presID));
        model.addAttribute("prescription", this.prescriptionService.getPrescriptionByID(presID));
        
        if(model.getAttribute("invoice") ==  null)
            model.addAttribute("invoice", new Invoice());
        if(model.getAttribute("success") == null)
            model.addAttribute("success","");
        
        String name = principal.getName();
        model.addAttribute("nurse",userDetailsService.getUser(name).get(0).getNurse());
        return "nurse-prescription-invoice";
    }
   
    @PostMapping("/nurse/invoice/prescription-list/{presid}/create")
    private String addServiceInvoiceProcess(Principal principal,Model model,@PathVariable(value ="presid") int id, @ModelAttribute(value = "invoice")@Valid Invoice m, BindingResult result
            ,RedirectAttributes attr, HttpSession session){
   
        if(!result.hasErrors())
        {   
            String name = principal.getName();
            
            m.setNurse(userDetailsService.getUser(name).get(0).getNurse());
            m.setPrescription(this.prescriptionService.getPrescriptionByID(id));
          
            m.setTotalPrice(BigDecimal.valueOf(Double.parseDouble("90000")));
            m.setCreatedDay(new Date());
            if(this.invoiceService.addOrUpdate(m)==true){
                attr.addFlashAttribute("success", "s");
                return"redirect:/nurse/invoice/prescription-list/" + id;
            }
            else{
                model.addAttribute("err","Something wrong");
                
            }
        }
        attr.addFlashAttribute("wrong", "");
        attr.addFlashAttribute("org.springframework.validation.BindingResult.medexcart", result);
        attr.addFlashAttribute("medexcart", m);
        return "redirect:/nurse/invoice/prescription-list/" + id ;
    }
}
