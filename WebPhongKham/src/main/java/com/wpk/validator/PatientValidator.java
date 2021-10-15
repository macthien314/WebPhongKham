/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.validator;

import com.wpk.pojos.Patient;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author macth
 */
@Component
public class PatientValidator implements Validator{
       @Override
    public boolean supports(Class<?> clazz) {
        return Patient.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Patient m = (Patient) target;
        if(m.getImage()== null && m.getFile().isEmpty()){
           errors.rejectValue("file", "slide.file.imageEmtyErr");
        }
    }
}
