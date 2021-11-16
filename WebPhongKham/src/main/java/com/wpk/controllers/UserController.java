/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.User;
import com.wpk.service.UserService;
import com.wpk.validator.UserImageValidator;
import com.wpk.validator.WebAppValidator;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
   @Autowired
   private UserService userDetailsService;

   @Autowired
    private WebAppValidator userValidator;
    @InitBinder
    public void initBider(WebDataBinder binder){
        binder.setValidator(userValidator);
    }
    @GetMapping("/login")
    public String login(Model model, HttpSession session){
        if(session.getAttribute("currentUser") != null)
            return "redirect:/";
        return "login";
    }
   
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model,@ModelAttribute(value = "user")@Valid User user,
            BindingResult result){
        if(!result.hasErrors())
        {    
            String errMassage = "";
            if(user.getPassword().equals(user.getConfirmPassword()))
            {
                if( this.userDetailsService.addUser(user) == true)
                    return "redirect:/login";
                else
                    errMassage="Có lỗi gì dó";

            }
            else errMassage ="mật khẩu không khớp";
            model.addAttribute("errMsg", errMassage);
        }
        return "register";
    }
}
