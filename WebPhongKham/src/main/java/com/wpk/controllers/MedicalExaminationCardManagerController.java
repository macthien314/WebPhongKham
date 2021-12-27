/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.service.MedicalExaminationCardService;
import com.wpk.service.NurseService;
import com.wpk.service.PatientService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author macth
 */
@Controller
public class MedicalExaminationCardManagerController {
     @Autowired
    private MedicalExaminationCardService medicalExaminationCardsService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private WebAppValidator medicalExaminationCardValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(medicalExaminationCardValidator);
   }
    @GetMapping("/admin/medicalexaminationcard-manager")
    public String MedicalExaminationCardManager(Model model, @RequestParam(required = false)Map<String, String> params){
        //xử lý lấy ngày
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        int nowYear = now.getYear();
              
        Date fromDate = null;
        Date toDate = null;
        try{  
            
            String from =params.getOrDefault("fromDate", null);

            if(from != null){
                fromDate = f.parse(from);
            }
              
            String to =params.getOrDefault("toDate",null);

            if(from != null){
               toDate = f.parse(to);
            }
        }catch(Exception e){
        }

        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "4");
        int page = 1;
        try{
            if(pageQuan.isEmpty() ){
                pageQuan = "4";
            }
            else if(!pageQuan.equals("all"))
                    if(!isNumeric(pageQuan))
                        pageQuan = "all";
                    else if(Integer.parseInt(pageQuan) <= 0)
                        pageQuan = "4";

             page= Integer.parseInt(params.getOrDefault("page", "1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        
         
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("fromDate", fromDate);
        model.addAttribute("toDate", toDate);
        
        model.addAttribute("medicalexaminationcards", this.medicalExaminationCardsService.getMedicalExaminationCards(fromDate, toDate,pageQuan, page));
        model.addAttribute("count", this.medicalExaminationCardsService.countMedCards(fromDate, toDate));

        return "medicalexaminationcard-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/medicalexaminationcard-manager/add-medicalexaminationcard")
    private String addMedicalShow(Model model){
        model.addAttribute("medicalexaminationcard", new MedicalExaminationCard());
        model.addAttribute("patients", this.patientService.getPatients());
        model.addAttribute("nurses", this.nurseService.getNurses());
        return "add-medicalexaminationcard";
   }
    @PostMapping("/admin/medicalexaminationcard-manager/add-medicalexaminationcard")
    private String addMedicalExaminationCardProcess(Model model, @ModelAttribute(value = "medicalexaminationcard")@Valid MedicalExaminationCard m, BindingResult result){
        model.addAttribute("patients", this.patientService.getPatients());
        model.addAttribute("nurses", this.nurseService.getNurses());
        if(!result.hasErrors())
        {      
            if(this.medicalExaminationCardsService.addOrUpdate(m)==true)
                    return "redirect:/admin/medicalexaminationcard-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-medicalexaminationcard";
    }
    
    
      @GetMapping("/admin/medicalexaminationcard-manager/edit-medicalexaminationcard/{medicalexaminationcardID}")
    public String editMedicalExaminationcCardIDShow(Model model,@PathVariable(value ="medicalexaminationcardID") int medicalexaminationcardID){
        MedicalExaminationCard m = this.medicalExaminationCardsService.getMedicalExaminationCardByID(medicalexaminationcardID);
        model.addAttribute("medicalexaminationcard", m);
        model.addAttribute("patients", this.patientService.getPatients());
        model.addAttribute("nurses", this.nurseService.getNurses());
        return "edit-medicalexaminationcard";
    }
    @PostMapping("/admin/medicalexaminationcard-manager/edit-medicalexaminationcard")
    public String editMedicalExaminationCardProsses(Model model, @ModelAttribute(value = "doctor")@Valid MedicalExaminationCard m, BindingResult result){
        model.addAttribute("patients", this.patientService.getPatients());
        model.addAttribute("nurses", this.nurseService.getNurses());
        if(!result.hasErrors())
        {   
            if(this.medicalExaminationCardsService.addOrUpdate(m)==true)
                    return "redirect:/admin/medicalexaminationcard-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/medicalexaminationcard-manager/edit-medicalexaminationcard/{"+m.getId().toString()+"}" ;
    }
    
    
     @RequestMapping(value="/admin/medicalexaminationcard-manager/delete-medicalexaminationcard/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteMedicalExaminationCard(Model model,@PathVariable(value ="id") int id){
        
        if(this.medicalExaminationCardsService.removeMedicalExaminationCard(id)){
            return "redirect:/admin/medicalexaminationcard-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/medicalexaminationcard-manager";
    }
     @GetMapping("/phieu-kham/{medicalexaminationcardsid}")
    public String medicalexaminationcards(Model model,@PathVariable(value ="medicalexaminationcardsid") int medicalexaminationcardsid){
        model.addAttribute("medicalexaminationcards", this.medicalExaminationCardsService.getMedicalExaminationCardByID(medicalexaminationcardsid));
        return "medicalexaminationcards-detail";
    }
}
