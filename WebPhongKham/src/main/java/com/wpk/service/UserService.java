/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService {
    boolean addUser(User user);
    boolean addDoctorUser(User user);
    List <User> getUser(String username);
    List <User> getUsers();
//    List<List<Map<Object, Object>>> getCanvasjsChartData();
   
}
