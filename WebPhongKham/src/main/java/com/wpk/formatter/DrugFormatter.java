/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;

import com.wpk.pojos.Drug;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author macth
 */
public class DrugFormatter implements Formatter<Drug> {
     @Override
    public String print(Drug object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Drug parse(String id, Locale locale) throws ParseException {
        Drug med = new Drug();
        med.setId(Integer.parseInt(id));
        return med;
    }
}
