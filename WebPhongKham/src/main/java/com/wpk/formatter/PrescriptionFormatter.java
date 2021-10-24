/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;

import com.wpk.pojos.Prescription;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author macth
 */
public class PrescriptionFormatter implements Formatter<Prescription> {
       @Override
    public String print(Prescription object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Prescription parse(String id, Locale locale) throws ParseException {
        Prescription med = new Prescription();
        med.setId(Integer.parseInt(id));
        return med;
    } 
}
