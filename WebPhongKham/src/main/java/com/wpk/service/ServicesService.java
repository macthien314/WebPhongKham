/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Services;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ServicesService {
    List<Services> getServices();
    
    Services getServicesByID(int id);
    boolean addOrUpdate(Services s);
    boolean removeServices(int id);
    long countService(String name);
    List<Services> getServices(String name, String pageQuan, int pageNum);
}
