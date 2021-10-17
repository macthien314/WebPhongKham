/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;

import com.wpk.pojos.Medical;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class MedicalFormatter implements Formatter<Medical>{



    @Override
    public String print(Medical object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Medical parse(String id, Locale locale) throws ParseException {
        Medical med = new Medical();
        med.setId(Integer.parseInt(id));
        return med;
    }
    
}
