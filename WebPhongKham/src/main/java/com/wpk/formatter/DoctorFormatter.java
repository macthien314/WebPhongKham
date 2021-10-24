/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;

import com.wpk.pojos.Doctor;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class DoctorFormatter implements Formatter<Doctor>{



    @Override
    public String print(Doctor object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Doctor parse(String id, Locale locale) throws ParseException {
        Doctor med = new Doctor();
        med.setId(Integer.parseInt(id));
        return med;
    }
    
}