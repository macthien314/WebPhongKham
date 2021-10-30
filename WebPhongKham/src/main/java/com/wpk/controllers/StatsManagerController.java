/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author macth
 */
@Controller
@RequestMapping("/admin")
public class StatsManagerController {
    @Autowired
    private StatsService statsService;    
     @GetMapping("/numpatient-month")   
     public String numPatientMonthStats(Model model){
        model.addAttribute("numPatientMonths", this.statsService.numPatientMonthStats(null, null));
       return "numpatient-month" ;  
    }


    
}
