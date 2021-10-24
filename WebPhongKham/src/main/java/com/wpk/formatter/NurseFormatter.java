/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;
import com.wpk.pojos.Nurse;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class NurseFormatter implements Formatter<Nurse>{



    @Override
    public String print(Nurse object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Nurse parse(String id, Locale locale) throws ParseException {
        Nurse med = new Nurse();
        med.setId(Integer.parseInt(id));
        return med;
    }
    
}