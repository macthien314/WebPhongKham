/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;

import com.wpk.pojos.Services;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ServicesRepository {
     List<Services> getServices();
    
     Services getServiceByID(int id);
     boolean addOrUpdate(Services s);
     boolean removeServices(int id);
     List<Services> getServices(String name, String pageQuan, int pageNum);
     long countService(String name);
}
