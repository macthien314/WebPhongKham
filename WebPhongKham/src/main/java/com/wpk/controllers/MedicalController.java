/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.MedicalService;
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
public class MedicalController {
    @Autowired
    private MedicalService medicalService;
    @GetMapping("/chuyen-khoa/{medicalid}")
    public String medical(Model model,@PathVariable(value ="medicalid") int medicalid){
        model.addAttribute("medical", this.medicalService.getMedicalByID(medicalid));
        return "medical-detail";
    }
}
