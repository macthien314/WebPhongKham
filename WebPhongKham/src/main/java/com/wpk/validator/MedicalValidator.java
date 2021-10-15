/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.validator;

import com.wpk.controllers.MedicalController;
import com.wpk.pojos.Medical;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */

@Component
public class MedicalValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Medical.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Medical m = (Medical) target;
        if(m.getImage()== null && m.getFile().isEmpty()){
           errors.rejectValue("file", "slide.file.imageEmtyErr");
        }
    }
    
}
