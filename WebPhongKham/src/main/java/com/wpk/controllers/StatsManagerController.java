/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
     public String numPatientMonthStats(Model model,@RequestParam(required = false)Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        int nowYear = now.getYear();
              
        Date fromDate = null;
        Date toDate = null;
        String from="2021-01-01";
        String to="2021-12-31";
        try{  
            
            from =params.getOrDefault("fromDate", null);

            if(from != null){
                fromDate = f.parse(from);
            }
              
            to =params.getOrDefault("toDate",null);

            if(from != null){
               toDate = f.parse(to);
            }
        }catch(Exception e){
        }
       
        model.addAttribute("fromDate", from);
        model.addAttribute("toDate", to);
       
        model.addAttribute("numPatientMonths", this.statsService.numPatientMonthStats(fromDate, toDate));
       return "numpatient-month" ;  
    }
     
       @GetMapping("revenuestats-month")   
     public String invoiceMonthStats(Model model, @RequestParam(required = false)Map<String, String> params) throws ParseException{
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        int nowYear = now.getYear();
              
        Date fromDate = null;
        Date toDate = null;
        String from="2021-01-01";
        String to="2021-12-31";
        try{  
            
             from =params.getOrDefault("fromDate", null);

            if(from != null){
                fromDate = f.parse(from);
            }
              
            to =params.getOrDefault("toDate",null);

            if(from != null){
               toDate = f.parse(to);
            }
        }catch(Exception e){
        }
        model.addAttribute("fromDate", from);
        model.addAttribute("toDate", to);
        model.addAttribute("revenueStats", this.statsService.revenueMonthStats(fromDate, toDate));
        return "invoicestats-month" ;  
    }
   
     @GetMapping("/")  
     public String coutabout(Model model,@RequestParam(required = false)Map<String, String> params) throws ParseException{
        model.addAttribute("countabouts", this.statsService.coutabout());
        return "cout-about";
     }
    
}
