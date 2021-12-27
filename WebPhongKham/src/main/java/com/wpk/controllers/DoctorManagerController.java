/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.User;
import com.wpk.service.DoctorService;
import com.wpk.service.UserService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
import java.text.Normalizer;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
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

public class DoctorManagerController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private WebAppValidator doctorValidator;
    @Autowired
    private UserService userDetailsService;
    @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(doctorValidator);
   }

    @RequestMapping("/admin/doctor-manager")
    public String DoctorManager (Model model, @RequestParam(required = false)Map<String, String> params){
        String firstName = params.getOrDefault("firstname", "");
        String lastName = params.getOrDefault("lastname", "");
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "3");
        String medID = params.getOrDefault("medid", "all");
        String account = params.getOrDefault("account", "all");
        int page = 1;
        try{
            if(pageQuan.isEmpty() ){
                pageQuan = "3";
            }
            else if(!pageQuan.equals("all"))
                    if(!isNumeric(pageQuan))
                        pageQuan = "all";
                    else if(Integer.parseInt(pageQuan) <= 0)
                        pageQuan = "3";

             page= Integer.parseInt(params.getOrDefault("page", "1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("doctors", this.doctorService.getDoctors(firstName, lastName, medID, account, pageQuan,page));
        model.addAttribute("count", this.doctorService.countDoctor(firstName, lastName, medID, account));
        
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("firstname", firstName);
        model.addAttribute("lastname", lastName);
        model.addAttribute("medid", medID);
        model.addAttribute("account", account);
        return "doctor-manager";
    }
    
    
 
    //chuc nang them bac si
    @GetMapping("/admin/doctor-manager/add-doctor")
    private String addDoctorShows(Model model){
        model.addAttribute("doctor", new Doctor());
        return "add-doctor";
   }
    @PostMapping("/admin/doctor-manager/add-doctor")
    private String addDoctorProcess(Model model, @ModelAttribute(value = "doctor")@Valid Doctor m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.doctorService.addOrUpdate(m)==true)
                    return "redirect:/admin/doctor-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-doctor";
    }
    
    //chuc nang xoa bac si
     @RequestMapping(value="/admin/doctor-manager/delete-doctor/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteDoctor(Model model,@PathVariable(value ="id") int id){
        try{
            if(this.doctorService.removeDoctor(id)){
            return "redirect:/admin/doctor-manager";
            }
            else model.addAttribute("err","Something wrong");
        }
        catch(Exception e){
        }
        return "redirect:/admin/doctor-manager";
    }
    
    //chuc nang sua bác sĩ
    
    @GetMapping("/admin/doctor-manager/edit-doctor/{doctorID}")
    public String editDoctorShow(Model model,@PathVariable(value ="doctorID") int doctorID){
        Doctor m = this.doctorService.getDoctorByID(doctorID);
        model.addAttribute("doctor", m);
        return "edit-doctor";
    }
    @PostMapping("/admin/doctor-manager/edit-doctor/{doctorID}")
    public String editDoctorProsses(Model model,@PathVariable(value ="doctorID") int doctorID, @ModelAttribute(value = "doctor")@Valid Doctor m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.doctorService.addOrUpdate(m)==true)
                    return "redirect:/admin/doctor-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "edit-doctor" ;
    }
    
    
    @GetMapping("/bac-si/{doctorid}")
    public String doctor(Model model,@PathVariable(value ="doctorid") int doctorid){
        model.addAttribute("doctor", this.doctorService.getDoctorByID(doctorid));
        return "doctor-detail";
    }
    
    //cấp tài khoản cho bác sĩ
    @PostMapping("/admin/doctor-manager/create-doctoruser")
    public String createDoctorUserProsses(Model model, @ModelAttribute(value = "doctor") Doctor m, BindingResult result){
        User u = new User();
        u.setDoctor(m);
        u.setUserRole("ROLE_DOCTOR");
        
        String username =m.getId().toString() + "doctor"+m.getFirstName()+m.getLastName();
        username = username.replaceAll("\\s+","");
        
        username=Normalizer.normalize(username, Normalizer.Form.NFD);
        username = username.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        username = username.toLowerCase();
        u.setUsername(username);
        u.setPassword("123456");
        u.setFirstName(m.getFirstName());
        u.setLastName(m.getLastName());
        u.setPhone(m.getPhone());
        u.setEmail(m.getEmail());
        u.setImage(m.getImage());
        u.setDoctor(m);
        
        m.setUser(u);
        if(!result.hasErrors())
        {   
            if(this.userDetailsService.addDoctorUser(u) ==true)
                    return "redirect:/admin/doctor-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/doctor-manager/edit-doctor/{"+m.getId().toString()+"}" ;
    }
}
