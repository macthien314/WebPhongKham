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
      
        return this.appointmentRepository.addOrUpdate(m);
    } 

    @Override
    public Appointment getAppointmentByID(int id) {
         return appointmentRepository.getAppointmentByID(id);
    }
    
    @Override
    public boolean removeAppointment(int i) {
        return this.appointmentRepository.removeAppointment(i);
    }

    @Override
    public List<Appointment> getAppointments(String appointmentID, String patientID, String pageQuan, int page) {
         return this.appointmentRepository.getAppointments(appointmentID, patientID, pageQuan, page);
    }

    @Override
    public long countAppointments(String appointmentID, String patientID) {
     return this.appointmentRepository.countAppointments(appointmentID, patientID);
    }
}
