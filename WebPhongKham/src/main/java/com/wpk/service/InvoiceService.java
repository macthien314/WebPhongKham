/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Invoice;
import java.util.List;



/**
 *
 * @author macth
 */
public interface InvoiceService {
     List<Invoice> getInvoices();
    Invoice getInvoiceByID(int id);
     boolean addOrUpdate(Invoice d);
     boolean removeInvoice(int id);
}
