/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;


import com.wpk.pojos.Services;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author macth
 */
public class ServicesFormatter implements Formatter<Services> {
       @Override
    public String print(Services object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Services parse(String id, Locale locale) throws ParseException {
        Services med = new Services();
        med.setId(Integer.parseInt(id));
        return med;
    } 
}
    

