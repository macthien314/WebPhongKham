/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.wpk.repository.StatsRepository;
import com.wpk.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macth
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;
    @Override
    public List<Object[]> numPatientMonthStats(Date fromDate, Date toDate) {
        return statsRepository.numPatientMonthStats(fromDate, toDate);
                }
}
