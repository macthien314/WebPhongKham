/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Patient;
import com.wpk.pojos.User;
import com.wpk.service.MedicalExaminationCardService;
import com.wpk.utils.util;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
public class DoctorDashboard {
    @Autowired
    private MedicalExaminationCardService medicalExaminationCardsService;
    @GetMapping("/doctor")
    public String doctorDashboard(HttpSession session,Model model){
        User u = (User) session.getAttribute("currentUser");
        List<MedicalExaminationCard> m = this.medicalExaminationCardsService.getTodayMedCard(u.getDoctor().getId());
        model.addAttribute("countAll", m.size() );
        model.addAttribute("countSuccess", util.countSuccessMed(m) );
        return "doctor-dashboard";
    }
}
