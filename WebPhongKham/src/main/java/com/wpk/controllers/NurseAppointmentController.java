/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Appointment;
import com.wpk.pojos.Patient;
import com.wpk.service.AppointmentService;
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
 * @author macth
 */
@Controller
public class NurseAppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private WebAppValidator appointmentValidator;
     @InitBinder
     public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(appointmentValidator);
   }
     @GetMapping("/nurse/appointment")
    public String AppointManager(Model model, @RequestParam(required = false)Map<String, String> params){
       String appointmentID = params.getOrDefault("appointmentID", "");
        if(!isNumeric(appointmentID))
            appointmentID = "";
        
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
        model.addAttribute("appointments",this.appointmentService.getAppointments(appointmentID, patientID,pageQuan,page));
        model.addAttribute("count", this.appointmentService.countAppointments(appointmentID, patientID));
        model.addAttribute("patients",this.patientService.getPatients()); 
        model.addAttribute("patientID", patientID);
        model.addAttribute("appointmentID",appointmentID);
         if(model.getAttribute("appointment") == null)
        model.addAttribute("appointment", new Appointment());
        return "nurse-appointment";
    }

     @PostMapping("/nurse/create-appointment")
    private String addAppointMentProcess(Model model, @ModelAttribute(value = "appointment")@Valid Appointment m, BindingResult result,
            RedirectAttributes attr, HttpSession session){
        
        if(!result.hasErrors())
        {      
            if(this.appointmentService.addOrUpdate(m)==true)
                    attr.addFlashAttribute("success","Thành công");
                    return "redirect:/nurse/appointment";
 
        }
        attr.addFlashAttribute("err","Đã có lỗi gì đó");
        
        attr.addFlashAttribute("org.springframework.validation.BindingResult.appointment", result);
        attr.addFlashAttribute("appointments", m);
        return "redirect:/nurse/appointment";
    }
    //chuc nang sua 
    
    @GetMapping("/nurse/appointment/edit-appointment/{appointmentId}")
    public String editAppointmentShow(Model model,@PathVariable(value ="appointmentId") int appointmentID){
        Appointment m = this.appointmentService.getAppointmentByID(appointmentID);
        model.addAttribute("appointment", m);
        model.addAttribute("patients",this.patientService.getPatients()); 
        return "nurse-edit-appointment";
    }
    @PostMapping("/nurse/appointment/edit-appointment/{appointmentId}")
    public String editAppointmentProsses(Model model,@PathVariable(value ="appointmentId") int appointmentId, @ModelAttribute(value = "appointment")@Valid Appointment m, BindingResult result){
        model.addAttribute("patients",this.patientService.getPatients()); 
        if(!result.hasErrors())
        {   
            if(this.appointmentService.addOrUpdate(m)==true)
                    return "redirect:/nurse/appointment";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "nurse-edit-appointment" ;
    } 
    
     //chuc nang xoa bac si
    @RequestMapping(value="/nurse/appointment/delete-appointment/{appointmentId}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteAppointment(Model model,@PathVariable(value ="appointmentId") int id,RedirectAttributes attr, HttpSession session){
        
        if(this.appointmentService.removeAppointment(id)){
            attr.addFlashAttribute("deleteSucces","Xóa thất bại");
            return "redirect:/nurse/appointment";
        }
        attr.addFlashAttribute("deleteErr","Xóa thất bại");
        
        return "redirect:/nurse/appointment";
    }
} 

