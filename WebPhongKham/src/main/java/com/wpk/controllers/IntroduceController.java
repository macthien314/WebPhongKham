/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author macth
 */
@Controller
public class IntroduceController {
    @GetMapping("/aboutus")
    public String aboutUs(){
    return "aboutus"; 
    }
    @GetMapping("/valuevision")
    public String valueVision(){
    return "valuevision";  
}
    @GetMapping("/organizationchart")
    public String organizationChart(){
    return "organizationchart";  
}
 
    
}
