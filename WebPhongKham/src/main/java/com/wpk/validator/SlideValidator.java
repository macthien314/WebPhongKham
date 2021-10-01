/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.validator;

import com.wpk.pojos.Slide;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */
@Component
public class SlideValidator implements Validator {
     @Override
    public boolean supports(Class<?> clazz) {
        return Slide.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Slide slide = (Slide) target;
     
        if(slide.getImage()== null && slide.getFile().isEmpty()){
           errors.rejectValue("file", "slide.file.imageEmtyErr");
        }
       
    }
}
