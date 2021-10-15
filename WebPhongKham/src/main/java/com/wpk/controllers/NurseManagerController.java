/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Nurse;
import com.wpk.service.NurseService;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author macth
 */
@Controller
public class NurseManagerController {
     @Autowired
    private NurseService nurseService;
    @Autowired
    private WebAppValidator nurseValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(nurseValidator);
   }
    @GetMapping("/admin/nurse-manager")
    public String NurseManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("nurse", new Nurse());
        model.addAttribute("nurses", this.nurseService.getNurses());
        return "nurse-manager";
    }
}
