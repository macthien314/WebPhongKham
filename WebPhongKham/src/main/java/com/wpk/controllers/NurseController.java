/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.NurseService;
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
public class NurseController {
    @Autowired
    private NurseService nurseService;
    @GetMapping("/y-ta/{nurseid}")
    public String nurse(Model model,@PathVariable(value ="nurseid") int nurseid){
        model.addAttribute("nurse", this.nurseService.getNurseByID(nurseid));
        return "nurse-detail";
}
}
