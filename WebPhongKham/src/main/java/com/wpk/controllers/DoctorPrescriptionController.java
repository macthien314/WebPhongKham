/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.DrugCart;
import com.wpk.pojos.Invoice;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Prescription;
import com.wpk.service.DoctorService;
import com.wpk.service.DrugService;
import com.wpk.service.MedicalExaminationCardService;
import com.wpk.service.PatientService;
import com.wpk.service.PrescriptionService;
import com.wpk.service.UserService;
import com.wpk.validator.WebAppValidator;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class DoctorPrescriptionController {
     @Autowired
    private DoctorService doctorService;
     @Autowired
     private DrugService drugService;
     @Autowired
    private PatientService patientService;
     @Autowired
    private PrescriptionService prescriptionService;
     @Autowired
    private MedicalExaminationCardService medicalExaminationCardsService;
    @Autowired
    private WebAppValidator prescriptionValidator;
    
   
    @Autowired
    private UserService userDetailsService;
    @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(prescriptionValidator);
   }
    //list today medcart axamination 
    @GetMapping("/doctor/today-medcard")
    public String todayMedCardList (Authentication aut,Model model){
        model.addAttribute("patients",this.patientService.getPatients());
        if(model.getAttribute("success") == null)
           model.addAttribute("success","");
        
        String name = aut.getName();
        Doctor d = userDetailsService.getUser(name).get(0).getDoctor();
        model.addAttribute("doctor",d);
        
        model.addAttribute("medExCarts", this.medicalExaminationCardsService.getTodayMedCard(d.getId()));
        return "doctor-today-medcard";
    }
    //recive and create prescription
    @GetMapping("doctor/today-medcard/receive/{medcardID}")
    public String recieveMedcard(Authentication aut,Model model,@PathVariable(value ="medcardID") int id,HttpSession session){        
        
        MedicalExaminationCard medCart = this.medicalExaminationCardsService.getMedicalExaminationCardByID(id);
        
        String name = aut.getName();
        Doctor d = userDetailsService.getUser(name).get(0).getDoctor();
        
        //redirect khi không phải phieu cua bac si
        if(!Objects.equals(medCart.getDoctor().getId(), d.getId()))
            return "redirect:/doctor/today-medcard";
        Map<Integer, DrugCart> drugCart = (Map<Integer, DrugCart>) session.getAttribute("drugCart");
        if(drugCart != null && !drugCart.isEmpty())
            model.addAttribute("drugCarts", drugCart.values());
        else model.addAttribute("drugCarts", null);
        
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("medcard", medCart);
        model.addAttribute("doctor", d);
        model.addAttribute("drugs", this.drugService.getUnexpiredDrug());
        return "recive-medcard";
    }
    
    //tạo toa thuốc
    @PostMapping("doctor/today-medcard/receive/{medcardID}")
    public String recievceAndCreate(Authentication aut,Model model,@PathVariable(value ="medcardID") int id, @ModelAttribute(value = "prescription")@Valid Prescription m, BindingResult result, HttpSession session){
        if(!result.hasErrors())
        {   
            MedicalExaminationCard medCart = this.medicalExaminationCardsService.getMedicalExaminationCardByID(id);
            Map<Integer, DrugCart> drugCart = (Map<Integer, DrugCart>) session.getAttribute("drugCart");
            if(this.prescriptionService.addPrescription(m, medCart,drugCart)==true){
               
                return"redirect:/doctor/today-medcard";
            }
            else{
                model.addAttribute("err","Something wrong");     
            }
        }
        return "recive-medcard";
    } 
}
