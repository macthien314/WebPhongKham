/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.pojos.ServiceInvoice;
import com.wpk.service.ServiceInvoiceService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author macth
 */
@Controller
public class ServiceInvoiceManagerController {
     @Autowired
    private ServiceInvoiceService serviceInvoiceService;
    @Autowired
    private WebAppValidator serviceInvoiceValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(serviceInvoiceValidator);
   }
    @GetMapping("/admin/serviceinvoice-manager")
    public String ServiceInvoiceManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("serviceinvoice", new ServiceInvoice());
        model.addAttribute("serviceinvoices", this.serviceInvoiceService.getServiceInvoices());
        return "serviceinvoice-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/serviceinvoice-manager/add-serviceinvoice")
    private String addServiceInvoiceShow(Model model){
        model.addAttribute("serviceinvoice", new ServiceInvoice());
        return "add-serviceinvoice";
   }
    @PostMapping("/admin/serviceinvoice-manager/add-serviceinvoice")
    private String addServiceInvoiceProcess(Model model, @ModelAttribute(value = "serviceinvoice")@Valid ServiceInvoice m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.serviceInvoiceService.addOrUpdate(m)==true)
                    return "redirect:/admin/serviceinvoice-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-serviceinvoice";
    }
    
}
