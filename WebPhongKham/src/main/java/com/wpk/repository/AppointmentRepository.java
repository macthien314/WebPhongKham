/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;
import com.wpk.pojos.Appointment;
import java.util.List;

/**
 *
 * @author macth
 */
public interface AppointmentRepository {
    List<Appointment> getAppointments();
     Appointment getAppointmentByID(int id);
     boolean addOrUpdate(Appointment m);
     boolean removeAppointment(int id);
    List<Appointment> getAppointments(String appointmentID, String patientID, String pageQuan, int page);
    long countAppointments(String appointmentID, String patientID);
}
