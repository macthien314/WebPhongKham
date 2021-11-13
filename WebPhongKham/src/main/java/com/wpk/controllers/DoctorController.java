/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/bac-si")
    public String doctor(Model model, String firstName, String lastName, String medID, String account, String pageQuan){
        model.addAttribute("doctor", this.doctorService.getDoctors(firstName, lastName, medID, account, pageQuan, 0));
        return "doctor-detail";
    }
}
