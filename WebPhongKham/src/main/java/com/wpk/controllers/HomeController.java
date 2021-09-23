/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.service.MedicalService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macth
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private MedicalService medicalService;
    @ModelAttribute
    public  void commonAttr(Model model, HttpSession session){
        model.addAttribute("medicals", this.medicalService.getMedicals());
    }
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("name", "Thien");
        return "index";
    }
    
}
