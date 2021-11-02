/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.validator;
import com.wpk.pojos.PrescriptionDrug;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author macth
 */
@Component
public class PrescriptionDrugValidator implements Validator {
        @Override
    public boolean supports(Class<?> clazz) {
        return  PrescriptionDrug.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
    }
    
}
