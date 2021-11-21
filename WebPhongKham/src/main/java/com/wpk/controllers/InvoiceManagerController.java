/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;
import com.wpk.pojos.Invoice;
import com.wpk.service.InvoiceService;
import com.wpk.service.NurseService;
import com.wpk.service.PrescriptionService;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author macth
 */
@Controller
public class InvoiceManagerController {
    @Autowired
    private InvoiceService invoiceService;
     @Autowired
    private PrescriptionService prescriptionService;
      @Autowired
    private NurseService nurseService;
    @Autowired
    private WebAppValidator invoiceValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(invoiceValidator);
   }
    @GetMapping("/admin/invoice-manager")
    public String InvoiceManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("invoices", this.invoiceService.getInvoices());
        return "invoice-manager";
    }
    //chuc nang them bac si
    @GetMapping("/admin/invoice-manager/add-invoice")
    private String addInvoiceShow(Model model){
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("nurses", this.nurseService.getNurses());
        model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions());
        return "add-invoice";
   }
    @PostMapping("/admin/invoice-manager/add-invoice")
    private String addInvoiceProcess(Model model, @ModelAttribute(value = "invoice")@Valid Invoice m, BindingResult result){
        model.addAttribute("nurses", this.nurseService.getNurses());
        model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions());
        if(!result.hasErrors())
        {      
            if(this.invoiceService.addOrUpdate(m)==true)
                    return "redirect:/admin/invoice-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-invoice";
    }
    
    //chuc nang xoa bac si
     @RequestMapping(value="/admin/invoice-manager/delete-invoice/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteInvoice (Model model,@PathVariable(value ="id") int id){
        
        if(this.invoiceService.removeInvoice(id)){
            return "redirect:/admin/invoice-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/invoice-manager";
    }
    
    //chuc nang sua y tá
    
    @GetMapping("/admin/invoice-manager/edit-invoice/{invoiceID}")
    public String editDoctorShow(Model model,@PathVariable(value ="invoiceID") int invoiceID){
        Invoice m = this.invoiceService.getInvoiceByID(invoiceID);
        model.addAttribute("invoice", m);
        model.addAttribute("nurses", this.nurseService.getNurses());
        model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions());
        return "edit-invoice";
    }
    @PostMapping("/admin/invoice-manager/edit-invoice")
    public String editInvoiceProsses(Model model, @ModelAttribute(value = "invoice")@Valid Invoice m, BindingResult result){
        model.addAttribute("nurses", this.nurseService.getNurses());
        model.addAttribute("prescriptions", this.prescriptionService.getPrescriptions());
        if(!result.hasErrors())
        {   
            if(this.invoiceService.addOrUpdate(m)==true)
                    return "redirect:/admin/invoice-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/invoice-manager/edit-invoice/{"+m.getId().toString()+"}" ;
    }
}
