/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.utils;

import com.wpk.pojos.DrugCart;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.PrescriptionDrug;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import java.util.List;
import org.apache.commons.lang.time.DateUtils;

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
                //s.add(p.getUnitPrice().multiply(BigDecimal.valueOf(p.getQuantity())));
            }
        Map<String, String> kq = new HashMap<>();
        kq.put("amount", String.valueOf(s));
        return kq;
    }
    public static int countCart(Map<Integer,DrugCart> drugCart){
        int q = 0;
        for(DrugCart c : drugCart.values())
            q += c.getQuantity();
        return q;
    }
    
    //kiểm tra thuốc trong toa còn đủ ko
    public static boolean checkDrug(List<PrescriptionDrug> pres){
        if(pres.size() <= 0)
            return false;
        for(PrescriptionDrug p : pres){
            if(p.getQuantity() > p.getDrug().getQuantity() || p.getDrug().getExpiry().before(new Date()))
                return false;
        }
        return true;
    }
     //Tính tiền
    public static BigDecimal presTotalPrice(List<PrescriptionDrug> pres){
        BigDecimal total =BigDecimal.valueOf(0) ;
        for(PrescriptionDrug p : pres){
            total = total.add( p.getDrug().getUnitPrice().multiply(BigDecimal.valueOf(p.getQuantity())));
        }
        return total;
    }
    
    //điếm số phiếu khám đã hoàn thành
    public static long countSuccessMed(List<MedicalExaminationCard> m){
        long count = 0;
        for(MedicalExaminationCard e : m){
            if(e.isReceive())
                count++;
        }
        return count;
    }
    
    public static boolean compareToNow(Date d){
        Date today = new Date();
        Date todayMorning = DateUtils.truncate(today, Calendar.DATE);
        Date todayEvening = DateUtils.addSeconds(DateUtils.addMinutes(DateUtils.addHours(todayMorning, 23), 59), 59);
        if(d.after(todayMorning) && d.before(todayEvening))
            return true;
        return false;
    }
}
