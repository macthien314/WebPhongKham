/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;


import com.wpk.pojos.Patient;
import com.wpk.pojos.ServiceInvoice;

import com.wpk.service.PatientService;
import com.wpk.service.ServiceInvoiceService;
import com.wpk.service.ServicesService;
import com.wpk.service.UserService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
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

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller

public class NurseServiceInvoiceController {
    @Autowired
    private PatientService patientService;
    
   @Autowired
   private UserService userDetailsService;
    @Autowired
    private ServiceInvoiceService serviceInvoiceService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private WebAppValidator serviceInvoiceValidator;
     @InitBinder
     public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(serviceInvoiceValidator);
   }
    @GetMapping("/nurse/patient-serviceinvoice")
    public String PatientManager(Model model, @RequestParam(required = false)Map<String, String> params){
        model.addAttribute("patient", new Patient());
        model.addAttribute("patients", this.patientService.getPatients());
        return "patient-serviceinvoice";
    }
    //trang hien thi cac hóa đơn của bệnh nhân
    @GetMapping("/nurse/patient-serviceinvoice/{patientID}")
    public String serviceInvoiceManager(Principal principal,Model model,@PathVariable(value ="patientID") int patientid
                                     ,@RequestParam(required = false)Map<String, String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
       
              
        Date fromDate = null;
        Date toDate = null;
        String from = params.getOrDefault("fromDate", null);
        String to =params.getOrDefault("toDate",null);
        try{  
            
            

            if(from != null){
                fromDate = f.parse(from);
            }
              
             

            if(from != null){
               toDate = f.parse(to);
            }
        }catch(Exception e){
        }
        
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "10");
        int page = 1;
        try{
            if(pageQuan.isEmpty() ){
                pageQuan = "10";
            }
            else if(!pageQuan.equals("all"))
                    if(!isNumeric(pageQuan))
                        pageQuan = "all";
                    else if(Integer.parseInt(pageQuan) <= 0)
                        pageQuan = "10";

             page= Integer.parseInt(params.getOrDefault("page", "1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        //atteibute liên quan tìm kiếm
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("fromDate", from);
        model.addAttribute("toDate", to);
        
        //attribute hien thi
        model.addAttribute("patient",this.patientService.getPatientByID(patientid));
        //lấy với phân trang
        model.addAttribute("serviceinvoices", this.serviceInvoiceService.getServiceInvoicesByPatient(patientid, fromDate, toDate,pageQuan, page));
        model.addAttribute("count", this.serviceInvoiceService.countServiceInvoicesByPatient(patientid, fromDate, toDate));

        if(model.getAttribute("serviceinvoice") == null)
        model.addAttribute("serviceinvoice",new ServiceInvoice());
        
        String name = principal.getName();
        model.addAttribute("nurse",userDetailsService.getUser(name).get(0).getNurse());
        return "serviceinvoice-list";
    }
    
    //tạo hóa đơn dịch vụ
    @PostMapping("/nurse/patient-serviceinvoice/{patientID}")
    private String addServiceInvoiceProcess(Principal principal,Model model,@PathVariable(value ="patientID") int patientid, @ModelAttribute(value = "serviceinvoice")@Valid ServiceInvoice m, BindingResult result
            ,RedirectAttributes attr, HttpSession session){
   
        if(!result.hasErrors())
        {   
            String name = principal.getName();
            m.setPatient(this.patientService.getPatientByID(patientid));
            m.setNurse(userDetailsService.getUser(name).get(0).getNurse());
            m.setFee(this.servicesService.getServicesByID(m.getService().getId()).getFee());
            
            if(this.serviceInvoiceService.addOrUpdate(m)==true){
                attr.addFlashAttribute("success", "Tạo hóa đơn dịch vụ thành công");
                return"redirect:/nurse/patient-serviceinvoice/" + patientid;
            }
          
        }
        attr.addFlashAttribute("err","Đã có lỗi gì đó");
        
        attr.addFlashAttribute("org.springframework.validation.BindingResult.serviceinvoice", result);
        attr.addFlashAttribute("serviceinvoice", m);
        return"redirect:/nurse/patient-serviceinvoice/" + patientid;
    }
}
