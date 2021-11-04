/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.utils;

import com.wpk.pojos.PrescriptionDrug;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


import javax.swing.Spring;

/**
 *
 * @author Admin
 */
public class util {
    public static boolean isNumeric(String string) {
    int intValue;
		
    System.out.println(String.format("Parsing string: \"%s\"", string));
		
    if(string == null || string.equals("")) {
        System.out.println("String cannot be parsed, it is null or empty.");
        return false;
    }
    
    try {
        intValue = Integer.parseInt(string);
        return true;
    } catch (NumberFormatException e) {
        System.out.println("Input String cannot be parsed to Integer.");
    }
    return false;
}
    
   

    public static Map<String, String> invoiceStats(Map<String, PrescriptionDrug> m) {
        BigDecimal s = null;

        
        if (m != null)
            for(PrescriptionDrug p: m.values())
            {
                s.add(p.getUnitPrice().multiply(BigDecimal.valueOf(p.getQuantity())));
            }
        Map<String, String> kq = new HashMap<>();
        kq.put("amount", String.valueOf(s));
        return kq;
    }

 
}
