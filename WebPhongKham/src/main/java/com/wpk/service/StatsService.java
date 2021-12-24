/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Revenue;
import java.util.Date;
import java.util.List;

/**
 *
 * @author macth
 */
public interface StatsService {
     List<Object[]> numPatientMonthStats(Date fromDate, Date toDate);
     List<Object[]> invoiceMonthStats(Date fromDate, Date toDate);
     List<Object[]> coutabout();
     //danh thu đến từ: hóa đơn, hóa đơn dịch vụ, phiếu khám
     List<Revenue> revenueMonthStats(Date fromDate, Date toDate);
}
