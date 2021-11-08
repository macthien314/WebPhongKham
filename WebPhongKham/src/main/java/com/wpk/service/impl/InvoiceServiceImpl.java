/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;
import com.cloudinary.Cloudinary;
import com.wpk.pojos.Invoice;
import com.wpk.repository.InvoiceRepository;
import com.wpk.service.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macth
 */
@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<Invoice> getInvoices() {
        return invoiceRepository.getInvoices();
    }

    @Override
    public Invoice getInvoiceByID(int id) {
        return invoiceRepository.getInvoiceByID(id);
    }

    @Override
    public boolean addOrUpdate(Invoice m) {
     
        return this.invoiceRepository.addOrUpdate(m);
    }
     @Override
    public boolean removeInvoice(int i) {
        return this.invoiceRepository.removeInvoice(i);
    }
    @Override
    public List<Invoice> getInvoicesByPres(int presID){
        return this.invoiceRepository.getInvoicesByPres(presID);
    }
}
