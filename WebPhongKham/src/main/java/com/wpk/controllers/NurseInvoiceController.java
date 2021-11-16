/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Invoice;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Patient;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.pojos.User;
import com.wpk.service.DoctorService;
import com.wpk.service.InvoiceService;
import com.wpk.service.PatientService;
import com.wpk.service.PrescriptionDrugService;
import com.wpk.service.PrescriptionService;
import com.wpk.service.UserService;
import com.wpk.utils.util;
import static com.wpk.utils.util.checkDrug;
import static com.wpk.utils.util.isNumeric;
import static com.wpk.utils.util.presTotalPrice;
import com.wpk.validator.WebAppValidator;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.List;
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
   private UserService userDetailsService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PrescriptionDrugService prescriptionDrugService;
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
    @GetMapping("/nurse/invoice/prescription-list")
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
    public String prescriptionInvoice(HttpSession session,Model model,@PathVariable(value ="presid") int presID){
        
        List<PrescriptionDrug> presDrugs = this.prescriptionDrugService.getPrescriptionDrugsByPres(presID);
        
        model.addAttribute("prescription", this.prescriptionService.getPrescriptionByID(presID));
        model.addAttribute("prescriptionDrugs",presDrugs);
        model.addAttribute("check", checkDrug(presDrugs));
        model.addAttribute("totalPrice",presTotalPrice(presDrugs));
        if(model.getAttribute("invoice") ==  null)
            model.addAttribute("invoice", new Invoice());
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("nurse",u.getNurse());
        return "nurse-prescription-invoice";
    }
   
    @PostMapping("/nurse/invoice/prescription-list/{presid}/create")
    private String createInvoiceProcess(Model model,@PathVariable(value ="presid") int presID, @ModelAttribute(value = "invoice")@Valid Invoice m, BindingResult result
            ,RedirectAttributes attr, HttpSession session){
         List<PrescriptionDrug> presDrugs = this.prescriptionDrugService.getPrescriptionDrugsByPres(presID);
        if(!result.hasErrors())
        {   
            User u = (User) session.getAttribute("currentUser");
            m.setTotalPrice(BigDecimal.ONE);
            m.setNurse(u.getNurse());
            m.setPrescription(this.prescriptionService.getPrescriptionByID(presID));
          
            m.setTotalPrice(BigDecimal.valueOf(Double.parseDouble("90000")));
            m.setCreatedDate(new Date());
            if(this.invoiceService.addOrUpdate(m)==true){
                attr.addFlashAttribute("success", "s");
                return"redirect:/nurse/invoice/prescription-list/" + presID;
            }
        }
        attr.addFlashAttribute("err","Something wrong");
        attr.addFlashAttribute("org.springframework.validation.BindingResult.medexcart", result);
        attr.addFlashAttribute("medexcart", m);
        return "redirect:/nurse/invoice/prescription-list/" + presID ;
    }
}
