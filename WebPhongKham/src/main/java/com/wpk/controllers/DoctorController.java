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
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author macth
 */
@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorServcie;
    @GetMapping("/bac-si/{doctorid}")
    public String doctor(Model model,@PathVariable(value ="doctorid") int doctorid){
        model.addAttribute("doctor", this.doctorServcie.getDoctorByID(doctorid));
        return "doctor-detail";
    }
}