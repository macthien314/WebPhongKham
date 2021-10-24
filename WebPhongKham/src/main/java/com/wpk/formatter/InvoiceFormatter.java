/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;

import com.wpk.pojos.Invoice;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author macth
 */
public class InvoiceFormatter implements Formatter<Invoice> {
   
    @Override
    public String print(Invoice object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Invoice parse(String id, Locale locale) throws ParseException {
        Invoice med = new Invoice();
        med.setId(Integer.parseInt(id));
        return med;
    } 
}
