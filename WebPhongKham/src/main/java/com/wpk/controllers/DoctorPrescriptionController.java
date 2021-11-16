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
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.pojos.User;
import com.wpk.service.DoctorService;
import com.wpk.service.DrugService;
import com.wpk.service.MedicalExaminationCardService;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    private PrescriptionDrugService prescriptionDrugService;
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
    @GetMapping("/doctor/today-medcard/receive/{medcardID}")
    public String recieveMedcard(Model model,@PathVariable(value ="medcardID") int id,HttpSession session){        
        
        MedicalExaminationCard medCart = this.medicalExaminationCardsService.getMedicalExaminationCardByID(id);
        
        User u = (User) session.getAttribute("currentUser");
        Doctor d = u.getDoctor();
        //redirect khi không phải phieu cua bac si
        if(!Objects.equals(medCart.getDoctor().getId(), d.getId()) || medCart == null || util.compareToNow(medCart.getDate()) == false)
            return "redirect:/doctor/today-medcard";
        Map<Integer, DrugCart> drugCart = (Map<Integer, DrugCart>) session.getAttribute("drugCart");
        
        if(drugCart != null && !drugCart.isEmpty())
            model.addAttribute("drugCarts", drugCart.values());
        else model.addAttribute("drugCarts", null);
        
        if(model.getAttribute("prescription") == null)
        model.addAttribute("prescription", new Prescription());
        model.addAttribute("medcard", medCart);
        model.addAttribute("doctor", d);
        model.addAttribute("drugs", this.drugService.getUnexpiredDrug());
        return "recive-medcard";
    }
    
    //tạo toa thuốc
    @PostMapping("/doctor/today-medcard/receive/{medcardID}")
    public String recievceAndCreate(Model model,@PathVariable(value ="medcardID") int id, @ModelAttribute(value = "prescription")@Valid Prescription m, BindingResult result, HttpSession session,RedirectAttributes attr){
        if(!result.hasErrors())
        {   
            User u = (User) session.getAttribute("currentUser");
            MedicalExaminationCard medCart = this.medicalExaminationCardsService.getMedicalExaminationCardByID(id);
            Map<Integer, DrugCart> drugCart = (Map<Integer, DrugCart>) session.getAttribute("drugCart");
            if(this.prescriptionService.addPrescription(m, medCart,drugCart)==true){
                session.setAttribute("drugCart", null);
                return"redirect:/doctor/today-medcard";
            }
          
        }
       
        attr.addFlashAttribute("err","Something wrong");
        
        attr.addFlashAttribute("org.springframework.validation.BindingResult.prescription", result);
        attr.addFlashAttribute("prescription", m);
        return "redirect:/doctor/today-medcard/receive/" + id ;
    } 
    @GetMapping("/doctor/prescription-list")
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
    @GetMapping("/doctor/prescription-list/{presid}")
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
}
