/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;


import com.wpk.pojos.Doctor;
import java.util.List;

/**
 *
 * @author macth
 */
public interface DoctorRepository {
    List<Doctor> getDoctor();
     Doctor getDoctorByID(int id);
     boolean addOrUpdate(Doctor m);
     boolean removeDoctor(int id);
}
