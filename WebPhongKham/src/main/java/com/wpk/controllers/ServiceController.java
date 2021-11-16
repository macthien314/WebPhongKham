/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Admin
 */
@Controller
public class ServiceController {
    @Autowired
    private ServicesService servicesService;
    
    @GetMapping("/dich-vu/{servicesid}")
    public String Services(Model model,@PathVariable(value ="servicesid") int servicesid){
        model.addAttribute("service", this.servicesService.getServicesByID(servicesid));
        return "services-detail";
    }
}
