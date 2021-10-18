/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.validator;

import com.wpk.pojos.MedicalExaminationCard;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author macth
 */
@Component
public class MedicalExaminationCardValidator implements Validator {
        @Override
    public boolean supports(Class<?> clazz) {
        return MedicalExaminationCard.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicalExaminationCard d = (MedicalExaminationCard) target;
        if(d.getFile().isEmpty()){
           errors.rejectValue("file", "slide.file.imageEmtyErr");
        }
    }
    
}
