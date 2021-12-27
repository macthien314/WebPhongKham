/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;
import javax.validation.Valid;
import com.wpk.pojos.Drug;
import com.wpk.service.DrugService;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
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
public class DrugManagerController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private WebAppValidator drugValidator;
     @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(drugValidator);
   }
    @GetMapping("/admin/drug-manager")
    public String DrugManager(Model model, @RequestParam(required = false)Map<String, String> params){
        
       
        String name = params.getOrDefault("name", "");
        
        //xử lý số lượng hiển thị trong 1 trang
        String pageQuan = params.getOrDefault("pagequan", "4");
        
        if(pageQuan.isEmpty()){
            pageQuan = "4";
        }
        else if(!pageQuan.equals("all"))
                if(pageQuan.contains("a") || pageQuan.contains("l"))
                    pageQuan = "all";
                else if(Integer.parseInt(pageQuan) <= 0)
                    pageQuan = "4";
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("drugs", this.drugService.getDrugs(name, pageQuan, page));
        model.addAttribute("count", this.drugService.countDrug(name));
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("name", name);
         return "drug-manager";
    }
    //chuc nang them chuyen khoa
    @GetMapping("/admin/drug-manager/add-drug")
    private String addDrugShow(Model model){
        model.addAttribute("drug", new Drug());
        return "add-drug";
   }
    @PostMapping("/admin/drug-manager/add-drug")
    private String addDrugsProcess(Model model, @ModelAttribute(value = "drug")@Valid Drug m, BindingResult result){
        if(!result.hasErrors())
        {      
            if(this.drugService.addOrUpdate(m)==true)
                    return "redirect:/admin/drug-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        return "add-drug";
    }
    
    //chuc nang sua thuốc
    
    @GetMapping("/admin/drug-manager/edit-drug/{drugID}")
    public String editDrugShow(Model model,@PathVariable(value ="drugID") int drugID){
        Drug m = this.drugService.getDrugByID(drugID);
        model.addAttribute("drug", m);
        return "edit-drug";
    }
    @PostMapping("/admin/drug-manager/edit-drug")
    public String editDrugProsses(Model model, @ModelAttribute(value = "drug")@Valid Drug m, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.drugService.addOrUpdate(m)==true)
                    return "redirect:/admin/drug-manager";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/drug-manager/edit-drug/{"+m.getId().toString()+"}" ;
    }
    
    @GetMapping("/thuoc/{drugid}")
    public String drug(Model model,@PathVariable(value ="drugid") int drugid){
        model.addAttribute("drug", this.drugService.getDrugByID(drugid));
        return "drug-detail";
    }
    
     @RequestMapping(value="/admin/drug-manager/delete-drug/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteDrug(Model model,@PathVariable(value ="id") int id){
        try{
            if(this.drugService.removeDrug(id)){
            return "redirect:/admin/drug-manager";
            }
            else model.addAttribute("err","Something wrong");
        }
        catch(Exception e){
        }
        return "redirect:/admin/drug-manager";
    }
}
    