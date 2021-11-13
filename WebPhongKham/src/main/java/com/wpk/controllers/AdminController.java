/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.DoctorService;
import com.wpk.service.StatsService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class AdminController {
    @Autowired
    private StatsService statsService;  
    //cotroller bang dieu khien 
    @GetMapping("/admin")
    public String admin(Model model){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null;
        Date toDate = null;
        Date now = new Date();
        int nowYear = now.getYear();
              
        
        try{  
            
            String from = "2021-01-01";
            fromDate = f.parse(from);
            
            String to ="2022-01-01";
            toDate = f.parse(to);
            
        }catch(Exception e){
        }
        model.addAttribute("revenueStats", this.statsService.revenueMonthStats(fromDate, toDate));

        model.addAttribute("numPatientMonths", this.statsService.numPatientMonthStats(fromDate, toDate));
        return "admin";
    }
    @GetMapping("/admin/thong-tin")
    public String adminProfile(){
        return "profile";
    }
      
    
}
