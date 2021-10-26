/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.pojos.Appointment;
import com.wpk.service.AppointmentService;
import com.wpk.validator.WebAppValidator;
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
public class AppointmentManagerController {
     @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private WebAppValidator appointmentValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(appointmentValidator);
   }
    @GetMapping("/admin/appointment-manager")
    public String  AppointmentManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("appointment", new  Appointment());
        model.addAttribute("appointments", this.appointmentService.getAppointments());
        return "appointment-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/appointment-manager/add-appointment")
    private String addAppointmentShow(Model model){
        model.addAttribute("appointment", new Appointment());
        return "add-appointment";
   }
    @PostMapping("/admin/appointment-manager/add-appointment")
    private String addAppointmentProcess(Model model, @ModelAttribute(value = "appointment")@Valid Appointment m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.appointmentService.addOrUpdate(m)==true)
                    return "redirect:/admin/appointment-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-appointment";
    }
    
        //chuc nang xoa bac si
     @RequestMapping(value="/admin/appointment-manager/delete-appointment/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteAppointment(Model model,@PathVariable(value ="id") int id){
        
        if(this.appointmentService.removeAppointment(id)){
            return "redirect:/admin/appointment-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/appointment-manager";
    }
    
    //chuc nang sua y tá
    
    @GetMapping("/admin/appointment-manager/edit-appointment/{appointmentID}")
    public String editAppointmentShow(Model model,@PathVariable(value ="appointmentID") int appointmentID){
        Appointment m = this.appointmentService.getAppointmentByID(appointmentID);
        model.addAttribute("appointment", m);
        return "edit-appointment";
    }
    @PostMapping("/admin/appointment-manager/edit-appointment")
    public String editAppointmentProsses(Model model, @ModelAttribute(value = "appointment")@Valid Appointment m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.appointmentService.addOrUpdate(m)==true)
                    return "redirect:/admin/appointment-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/appointment-manager/edit-appointment/{"+m.getAppointmentId().toString()+"}" ;
    }
    
}
