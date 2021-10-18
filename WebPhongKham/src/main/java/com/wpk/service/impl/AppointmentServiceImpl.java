/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Appointment;
import com.wpk.repository.AppointmentRepository;
import com.wpk.service.AppointmentService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macth
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {
   @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<Appointment> getAppointments() {
        return appointmentRepository.getAppointments();
    }

      @Override
    public boolean addOrUpdate(Appointment m) {
        if(!m.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(m.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","Appointment"));
        
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
        return this.appointmentRepository.addOrUpdate(m);
    } 

    @Override
    public Appointment getAppointmentByID(int id) {
         return appointmentRepository.getAppointmentByID(id);
    }
}
