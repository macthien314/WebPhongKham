/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author macth
 */
public interface StatsRepository {
    List<Object[]> numPatientMonthStats(Date fromDate, Date toDate); 
    
}
