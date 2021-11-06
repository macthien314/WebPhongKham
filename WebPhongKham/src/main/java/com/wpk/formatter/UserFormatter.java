/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.formatter;

import com.wpk.pojos.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author macth
 */
public class UserFormatter implements Formatter<User>{
     @Override
    public String print(User object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public User parse(String id, Locale locale) throws ParseException {
        User med = new User();
        med.setId(Integer.parseInt(id));
        return med;
    }
}
