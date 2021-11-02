/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.validator;



import com.wpk.pojos.Appointment;
import com.wpk.pojos.Doctor;
import com.wpk.pojos.Drug;
import com.wpk.pojos.Invoice;
import com.wpk.pojos.Medical;
import com.wpk.pojos.MedicalExaminationCard;
import com.wpk.pojos.Nurse;
import com.wpk.pojos.Patient;
import com.wpk.pojos.Prescription;
import com.wpk.pojos.PrescriptionDrug;
import com.wpk.pojos.Services;
import com.wpk.pojos.ServiceInvoice;
import com.wpk.pojos.Slide;
import com.wpk.pojos.User;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Admin
 */
@Component
public class WebAppValidator implements Validator{
    @Autowired
    private javax.validation.Validator beanValidator;
    private Set<Validator> springValidator;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz)
                ||Slide.class.isAssignableFrom(clazz)
                ||Medical.class.isAssignableFrom(clazz)
                ||Doctor.class.isAssignableFrom(clazz)
                ||Nurse.class.isAssignableFrom(clazz)
                ||Drug.class.isAssignableFrom(clazz)
                ||Patient.class.isAssignableFrom(clazz)
                ||MedicalExaminationCard.class.isAssignableFrom(clazz)
                ||Appointment.class.isAssignableFrom(clazz)
                ||ServiceInvoice.class.isAssignableFrom(clazz)
                ||Prescription.class.isAssignableFrom(clazz)
                ||Invoice.class.isAssignableFrom(clazz)
                ||Services.class.isAssignableFrom(clazz)
                ||PrescriptionDrug.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(target);
       for(ConstraintViolation<Object> obj: beans)
           errors.rejectValue(obj.getPropertyPath().toString(),obj.getMessageTemplate(), 
                   obj.getMessage());
       for(Validator v : springValidator)
           v.validate(target, errors);
       
       
    }

    public void setSpringValidator(Set<Validator> springValidator) {
        this.springValidator = springValidator;
    }
    
}
