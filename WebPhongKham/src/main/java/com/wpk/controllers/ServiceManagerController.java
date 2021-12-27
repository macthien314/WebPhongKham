/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Doctor;
import com.wpk.pojos.Services;
import com.wpk.service.ServicesService;
import static com.wpk.utils.util.isNumeric;
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
 * @author Admin
 */
@Controller
public class ServiceManagerController {
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private WebAppValidator servicesValidator;
   @InitBinder
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(servicesValidator);
   }
    @RequestMapping("/admin/services-manager")
    public String ServiceManager(Model model, @RequestParam(required = false)Map<String, String> params)
    {   
        
        String name = params.getOrDefault("name", "");
        
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "4");
        
        int page = 1;
        try{
            if(pageQuan.isEmpty() ){
                pageQuan = "4";
            }
            else if(!pageQuan.equals("all"))
                    if(!isNumeric(pageQuan))
                        pageQuan = "all";
                    else if(Integer.parseInt(pageQuan) <= 0)
                        pageQuan = "4";

             page= Integer.parseInt(params.getOrDefault("page", "1"));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        model.addAttribute("services", this.servicesService.getServices(name, pageQuan, page));
        
        model.addAttribute("count", this.servicesService.countService(name));
        
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("name", name);
        return "services-manager";
    }
    //chuc nang them dịch vụ
    @GetMapping("/admin/services-manager/add-services")
    private String addServiceShow(Model model){
        model.addAttribute("service", new Services());
        return "add-services";
   }
    @PostMapping("/admin/services-manager/add-services")
    private String addServicesProcess(Model model, @ModelAttribute(value = "service")@Valid Services s, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.servicesService.addOrUpdate(s)==true)
                    return "redirect:/admin/services-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-services";
    }
    
      @RequestMapping(value="/admin/services-manager/delete-services/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteService(Model model,@PathVariable(value ="id") int id){
        
        if(this.servicesService.removeServices(id)){
            return "redirect:/admin/services-manager";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/services-manager";
    }
    
    //chuc nang sua y tá
    
    @GetMapping("/admin/services-manager/edit-services/{servicesID}")
    public String editServicesShow(Model model,@PathVariable(value ="servicesID") int servicesID){
        Services m = this.servicesService.getServicesByID(servicesID);
        model.addAttribute("service", m);
        return "edit-services";
    }
    @PostMapping("/admin/services-manager/edit-services/{servicesID}")
    public String editServicesProsses(Model model,@PathVariable(value ="servicesID") int servicesID, @ModelAttribute(value = "service")@Valid Services m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.servicesService.addOrUpdate(m)==true)
                    return "redirect:/admin/services-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "edit-services" ;
    }
    
    
}
