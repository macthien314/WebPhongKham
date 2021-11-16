/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.service.DoctorService;
import com.wpk.service.MedicalExaminationCardService;
import com.wpk.service.PatientService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class NurseMedCardController {
    @Autowired
    private DoctorService doctorService;
     @Autowired
    private PatientService patientService;
     @Autowired
    private MedicalExaminationCardService medicalExaminationCardsService;
    @Autowired
    private WebAppValidator medicalExaminationCardValidator;
    
   
    @Autowired
    private UserService userDetailsService;
    @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(medicalExaminationCardValidator);
   }

    @RequestMapping("/nurse/medical-examination-card")
    public String doctorMedCard (Model model, @RequestParam(required = false)Map<String, String> params){
        String firstName = params.getOrDefault("firstname", "");
        String lastName = params.getOrDefault("lastname", "");
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "10");
        String medID = params.getOrDefault("medid", "all");
        int page = 1;
        try{
            if(pageQuan.isEmpty() )
                pageQuan = "10";

            else if(!pageQuan.equals("all"))
                    if(!isNumeric(pageQuan))
                        pageQuan = "all";
                    else if(Integer.parseInt(pageQuan) <= 0)
                        pageQuan = "10";
            page = Integer.parseInt(params.getOrDefault("page", "1"));
        }
         catch(Exception e){
             e.printStackTrace();
         }
        
        model.addAttribute("doctors", this.doctorService.getDoctorsWithMedCount(firstName, lastName, medID, "1", pageQuan,page));
        model.addAttribute("count", this.doctorService.countDoctor(firstName, lastName, medID, "1"));
        
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("firstname", firstName);
        model.addAttribute("lastname", lastName);
        model.addAttribute("medid", medID);

        return "nurse-medcard";
    }
    @GetMapping("/nurse/medical-examination-card/{doctorid}")
    public String todayMedCardList (Principal principal,Model model,@PathVariable(value ="doctorid") int id){
        model.addAttribute("patients",this.patientService.getPatients());
        model.addAttribute("doctor", this.doctorService.getDoctorByID(id));
        model.addAttribute("medicalexaminationcard", new MedicalExaminationCard());
        model.addAttribute("medExCarts", this.medicalExaminationCardsService.getTodayMedCard(id));
        
        if(model.getAttribute("medexcart") == null)
        model.addAttribute("medexcart",new MedicalExaminationCard());
        String name = principal.getName();
        model.addAttribute("nurse",userDetailsService.getUser(name).get(0).getNurse());
        return "nurse-medcardlist";
    }
    @PostMapping("/nurse/medical-examination-card/{doctorid}/create")
    private String addMedCardProcess(Principal principal,Model model,@PathVariable(value ="doctorid") int id, @ModelAttribute(value = "medexcart")@Valid MedicalExaminationCard m, BindingResult result
            ,RedirectAttributes attr, HttpSession session){
   
        if(!result.hasErrors())
        {   
            String name = principal.getName();
            
            m.setNurse(userDetailsService.getUser(name).get(0).getNurse());
            m.setDoctor(this.doctorService.getDoctorByID(id));
            m.setNum(this.medicalExaminationCardsService.countTodayMedCard(id) + 1);
            m.setFee(BigDecimal.valueOf(Double.parseDouble("90000")));
            m.setDate(new Date());
            m.setReceive(false);
            if(this.medicalExaminationCardsService.addOrUpdate(m)==true){
                attr.addFlashAttribute("success", "Tạo hóa đơn thành công");
                return"redirect:/nurse/medical-examination-card/" + id;
            }
            
        }
        attr.addFlashAttribute("err","Something wrong");
        
        attr.addFlashAttribute("org.springframework.validation.BindingResult.medexcart", result);
        attr.addFlashAttribute("medexcart", m);
        return "redirect:/nurse/medical-examination-card/" + id ;
    }
}
