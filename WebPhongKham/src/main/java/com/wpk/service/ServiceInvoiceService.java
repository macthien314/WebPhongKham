/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;
import com.wpk.pojos.ServiceInvoice;
import java.util.Date;
import java.util.List;


/**
 *
 * @author macth
 */
public interface ServiceInvoiceService {
    List<ServiceInvoice> getServiceInvoices();
    ServiceInvoice getServiceInvoiceByID(int id);
    boolean addOrUpdate(ServiceInvoice m);
    boolean removeServiceInvoice(int id);
    List<ServiceInvoice> getServiceInvoicesByPatient(int patientiID,Date fromDate,Date toDate,String pageQuan,int page);
    long countServiceInvoicesByPatient(int patientid,Date fromDate,Date toDate);

}
