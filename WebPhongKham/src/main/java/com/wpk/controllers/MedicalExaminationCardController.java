/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.service.MedicalExaminationCardService;
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
public class MedicalExaminationCardController {
    @Autowired
    private MedicalExaminationCardService medicalExaminationCardsService;
    @GetMapping("/phieu-kham/{medicalexaminationcardsid}")
    public String medical(Model model,@PathVariable(value ="medicalexaminationcardsid") int medicalexaminationcardsid){
        model.addAttribute("medicalexaminationcards", this.medicalExaminationCardsService.getMedicalExaminationCardByID(medicalexaminationcardsid));
        return "medicalexaminationcards-detail";
    }}
