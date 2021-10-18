/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.repository;
import com.wpk.pojos.ServiceInvoice;
import java.util.List;

/**
 *
 * @author macth
 */
public interface ServiceInvoiceRepository {
    List<ServiceInvoice> getServiceInvoice();
     ServiceInvoice getServiceInvoiceByID(int id);
     boolean addOrUpdate(ServiceInvoice m); 
}
