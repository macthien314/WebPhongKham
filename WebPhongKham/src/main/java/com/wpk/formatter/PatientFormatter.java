/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;
import com.wpk.pojos.Patient;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class PatientFormatter implements Formatter<Patient>{



    @Override
    public String print(Patient object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Patient parse(String id, Locale locale) throws ParseException {
        Patient med = new Patient();
        med.setId(Integer.parseInt(id));
        return med;
    }
    
}
