/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.google.common.collect.HashBiMap;
import com.wpk.pojos.Revenue;
import com.wpk.repository.StatsRepository;
import com.wpk.service.StatsService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.DuplicateMappingException;
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

    @Override
    public List<Object[]> invoiceMonthStats(Date fromDate, Date toDate) {
        return statsRepository.invoiceMonthStats(fromDate, toDate);
    }

    //lấy tổng danh thu từ cả: hóa đơn, hóa đơn dịch vụ, phiếu khám
    @Override
    public List<Revenue> revenueMonthStats(Date fromDate, Date toDate) {
        List<Object[]> m = this.statsRepository.medCardRevenueMonthStats(fromDate, toDate);
        List<Object[]> i = this.statsRepository.invoiceMonthStats(fromDate, toDate);
        List<Object[]> sInvoice = this.statsRepository.serviceInvoiceMonthStats(fromDate, toDate);
        
        List<Revenue> revenues = new ArrayList<>();
        
        for(Object[] obj : m){
            Revenue r = new Revenue((Integer)obj[0], (Integer)obj[1], (BigDecimal)obj[2]);
            if(!revenues.contains(new Revenue((Integer)obj[0], (Integer)obj[1]))) {
                revenues.add(r);
            } 
            else{
                Revenue r2 = revenues.get(revenues.indexOf(r));
                r2.setPrice( r2.getPrice().add(r.getPrice()));
            }
        
        }
        for(Object[] obj : i){
           Revenue r = new Revenue((Integer)obj[0], (Integer)obj[1], (BigDecimal)obj[2]);
            if(!revenues.contains(new Revenue((Integer)obj[0], (Integer)obj[1]))) {
                revenues.add(r);
            } 
            else{
                 Revenue r2 = revenues.get(revenues.indexOf(r));
                r2.setPrice( r2.getPrice().add(r.getPrice()));
            }
        
        }
        for(Object[] obj : sInvoice){
                      Revenue r = new Revenue((Integer)obj[0], (Integer)obj[1], (BigDecimal)obj[2]);

            if(!revenues.contains(new Revenue((Integer)obj[0], (Integer)obj[1]))) {
                revenues.add(r);
            } 
            else{
                Revenue r2 = revenues.get(revenues.indexOf(r));
                r2.setPrice( r2.getPrice().add(r.getPrice()));
            }
        
        }
        Collections.sort(revenues);
        return revenues;
    }

    @Override
    public List<Object[]> coutabout() {
         return statsRepository.coutabout();
    }
    
}
