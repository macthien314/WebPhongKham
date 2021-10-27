/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Admin
 */
@Controller
public class UserManagerController {
    @Autowired
    private UserService userService;
  
   
    @RequestMapping("/admin/user-manager/normal-user")
    public String userManager(Model model, @RequestParam(required = false) Map<String, String> params){
        String quatity = params.getOrDefault("quantity", "10");
        String name = params.getOrDefault("name", "");
       
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("users", this.userService.getUsers());
        return "user-manager";
    }
    @RequestMapping("/admin/user-manager/doctor-user")
    public String doctorUserManager(Model model, @RequestParam(required = false) Map<String, String> params){
        String quatity = params.getOrDefault("quantity", "10");
        String name = params.getOrDefault("name", "");
       
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("users", this.userService.getUsers());
        return "doctor-user";
    }
    @RequestMapping("/admin/user-manager/nurse-user")
    public String nurseUserManager(Model model, @RequestParam(required = false) Map<String, String> params){
        String quatity = params.getOrDefault("quantity", "10");
        String name = params.getOrDefault("name", "");
       
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("users", this.userService.getUsers());
        return "nurse-user";
    }
}
