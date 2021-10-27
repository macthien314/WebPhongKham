/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;
import com.wpk.pojos.ServiceInvoice;
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
}
