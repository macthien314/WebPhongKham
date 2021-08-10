/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macth
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("name", "Thien");
        return "index";
    }
    
}
