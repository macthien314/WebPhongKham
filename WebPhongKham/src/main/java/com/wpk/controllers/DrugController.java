/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.DrugService;
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
public class DrugController {
    @Autowired
    private DrugService drugService;
    @GetMapping("/thuoc/{drugid}")
    public String drug(Model model,@PathVariable(value ="drugid") int drugid){
        model.addAttribute("drug", this.drugService.getDrugByID(drugid));
        return "drug-detail";
    }
}
