/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;


import com.wpk.pojos.Appointment;
import java.util.List;


/**
 *
 * @author macth
 */
public interface AppointmentService {
           List<Appointment> getAppointments();
    Appointment getAppointmentByID(int id);
     boolean addOrUpdate(Appointment m);
}
