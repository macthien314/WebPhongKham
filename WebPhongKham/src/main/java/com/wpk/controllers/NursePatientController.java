/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Patient;
import com.wpk.service.PatientService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
public class NursePatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private WebAppValidator patientValidator;
     @InitBinder
     public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(patientValidator);
   }
     @GetMapping("/nurse/patient")
    public String PatientManager(Model model, @RequestParam(required = false)Map<String, String> params){
        String firstName = params.getOrDefault("firstname", "");
        String lastName = params.getOrDefault("lastname", "");
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "3");
        String account = params.getOrDefault("account", "all");
        int page = 1;
        try{
            if(pageQuan.isEmpty() ){
                pageQuan = "10";
            }
            else if(!pageQuan.equals("all"))
                    if(!isNumeric(pageQuan))
                        pageQuan = "all";
                    else if(Integer.parseInt(pageQuan) <= 0)
                        pageQuan = "10";

             page= Integer.parseInt(params.getOrDefault("page", "1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        model.addAttribute("patients", this.patientService.getPatients(firstName, lastName, account, pageQuan,page));
        model.addAttribute("count", this.patientService.countPatient(firstName, lastName, account));
        
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("firstname", firstName);
        model.addAttribute("lastname", lastName);
        
        model.addAttribute("account", account);
        if(model.getAttribute("patient") == null)
        model.addAttribute("patient", new Patient());
        return "nurse-patient-manager";
    }
     @PostMapping("/nurse/create-patient")
    private String addPatientProcess(Model model, @ModelAttribute(value = "patient")@Valid Patient m, BindingResult result,
            RedirectAttributes attr, HttpSession session){
        if(!result.hasErrors())
        {      
            if(this.patientService.addOrUpdate(m)==true)
                    attr.addFlashAttribute("success","Thành công");
                    return "redirect:/nurse/patient";
 
        }
        attr.addFlashAttribute("err","Đã có lỗi gì đó");
        
        attr.addFlashAttribute("org.springframework.validation.BindingResult.patient", result);
        attr.addFlashAttribute("patient", m);
        return "redirect:/nurse/patient";
    }
    //chuc nang sua y tá
    
    @GetMapping("/nurse/patient/edit-patient/{patientID}")
    public String editPatientShow(Model model,@PathVariable(value ="patientID") int patientID){
        Patient m = this.patientService.getPatientByID(patientID);
        model.addAttribute("patient", m);
        return "nurse-edit-patient";
    }
    @PostMapping("/nurse/patient/edit-patient/{patientID}")
    public String editPatientProsses(Model model,@PathVariable(value ="patientID") int patientID, @ModelAttribute(value = "patient")@Valid Patient m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.patientService.addOrUpdate(m)==true)
                    return "redirect:/nurse/patient";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "nurse-edit-patient" ;
    } 
    
     //chuc nang xoa bac si
    @RequestMapping(value="/nurse/patient/delete-patient/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deletePatient(Model model,@PathVariable(value ="id") int id,RedirectAttributes attr, HttpSession session){
        
        if(this.patientService.removePatient(id)){
            attr.addFlashAttribute("deleteSucces","Xóa thất bại");
            return "redirect:/nurse/patient";
        }
        attr.addFlashAttribute("deleteErr","Xóa thất bại");
        
        return "redirect:/nurse/patient";
    }
}
