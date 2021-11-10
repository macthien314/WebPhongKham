/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.DrugCart;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@RestController
public class ApiDrugCartController {
    @PostMapping("/doctor/api/drug-cart")
    public void addToDrugCart(@RequestBody DrugCart params, HttpSession session){
        Map<Integer,DrugCart> drugCart = (Map<Integer,DrugCart>) session.getAttribute("drugCart");
        
        if(drugCart == null){
            drugCart = new HashMap<>();
        }
        int drugID = params.getDrugID();
        
        if(drugCart.containsKey(drugID) == true){
            DrugCart c = drugCart.get(drugID);
            c.setQuantity(c.getQuantity() + 1);
        }
        else drugCart.put(drugID, params);
        
        session.setAttribute("drugCart", drugCart);
        
       
    }
    @PutMapping("/doctor/api/drug-cart")
    @ResponseStatus(HttpStatus.OK)
    public void updateDrugCart(@RequestBody DrugCart params, HttpSession session){
        Map<Integer,DrugCart> drugCart = (Map<Integer,DrugCart>) session.getAttribute("drugCart");
        
        if(drugCart == null){
            drugCart = new HashMap<>();
        }
        int drugID = params.getDrugID();
        
        if(drugCart.containsKey(drugID) == true){
            DrugCart c = drugCart.get(drugID);
            c.setQuantity(params.getQuantity());
            c.setUserGuide(params.getUserGuide());
        }
        
        session.setAttribute("drugCart", drugCart);
    }
    @DeleteMapping("/doctor/api/drug-cart/{cartid}")
    public void deleteDrugCartItem(@PathVariable("cartid") int id, HttpSession session){
        Map<Integer,DrugCart> drugCart = (Map<Integer,DrugCart>) session.getAttribute("drugCart");
        if(drugCart != null && drugCart.containsKey(id) == true ){
            drugCart.remove(id);
            session.setAttribute("drugCart", drugCart);
        }
    }
}
