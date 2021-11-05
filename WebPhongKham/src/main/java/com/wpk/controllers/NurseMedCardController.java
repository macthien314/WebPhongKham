/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.DoctorService;
import com.wpk.service.UserService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class NurseMedCardController {
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

    @RequestMapping("/nurse/medical-excard")
    public String DoctorManager (Model model, @RequestParam(required = false)Map<String, String> params){
        String firstName = params.getOrDefault("firstname", "");
        String lastName = params.getOrDefault("lastname", "");
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "10");
        String medID = params.getOrDefault("medid", "all");
        String account = params.getOrDefault("account", "all");
        if(pageQuan.isEmpty() ){
            pageQuan = "10";
        }
        else if(!pageQuan.equals("all"))
                if(!isNumeric(pageQuan))
                    pageQuan = "all";
                else if(Integer.parseInt(pageQuan) <= 0)
                    pageQuan = "10";
           
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
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
}
