/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Doctor;
import java.util.List;



/**
 *
 * @author macth
 */
public interface DoctorService {
     List<Doctor> getDoctor(String kw, int page );
     long countDoctor();
     Doctor getDoctorByID(int id);
     boolean addOrUpdate(Doctor d);
     boolean removeDoctor(int id);
}

