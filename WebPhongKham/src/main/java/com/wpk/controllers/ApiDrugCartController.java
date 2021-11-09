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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiDrugCartController {
    @PostMapping("/doctor/api/drug-cart")
    public int addToDrugCart(@RequestBody DrugCart params, HttpSession session){
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
        
        return 1;
    }
}
