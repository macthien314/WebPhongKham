/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Slide;
import com.wpk.service.SlideService;
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
public class SlideManagerController {
    @Autowired
    private SlideService slideService;
   @Autowired
    private WebAppValidator slideValidator;
   @InitBinder 
   public void initBinder(WebDataBinder binder)
   { 
       binder.setValidator(slideValidator);
   }
    @RequestMapping("/admin/quanly-slide")
    public String slideManager(Model model, @RequestParam(required = false)Map<String, String> params)
    {   
        
        String quantity = params.getOrDefault("quantity", "10");
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("slides", this.slideService.getSlides(page,quantity));
        return "slide-manager";
    }
    //Xem chi tiết slide
    @GetMapping("/admin/quanly-slide/chitiet-slide/{slideID}")
    public String slideInformation(Model model,@PathVariable(value ="slideID") int slideID){
        model.addAttribute("slide", this.slideService.getSlideByID(slideID));
        return "slide-infomation";
    }
    
    //Chức năng thêm
    @GetMapping("/admin/quanly-slide/them-slide")
    public String addSlidesShow(Model model)
    {
        model.addAttribute("slide", new Slide());
        return "add-slide";
    }
    @PostMapping("/admin/quanly-slide/them-slide")
    public String addSlideProcess(Model model, @ModelAttribute(value = "slide")@Valid Slide s, BindingResult result){
        
        if(!result.hasErrors())
        {      
            if(this.slideService.addOrUpdate(s)==true)
                    return "redirect:/admin/quanly-slide";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "add-slide";
    }
    @RequestMapping(value="/admin/quanly-slide/xoa-slide/{id}",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String deleteSlide(Model model,@PathVariable(value ="id") int id){
        
        if(this.slideService.removeSlide(id)){
            return "redirect:/admin/quanly-slide";
        }
        else model.addAttribute("err","Something wrong");
        
        return "redirect:/admin/quanly-slide";
    }
    //chức năng sửa slide
    @GetMapping("/admin/quanly-slide/sua-slide/{slideID}")
    public String editSlideShow(Model model,@PathVariable(value ="slideID") int slideID){
        Slide s = this.slideService.getSlideByID(slideID);
        model.addAttribute("slide", s);
        return "edit-slide";
    }
    @PostMapping("/admin/quanly-slide/sua-slide")
    public String editSlideProsses(Model model, @ModelAttribute(value = "slide")@Valid Slide s, BindingResult result){
        
        if(!result.hasErrors())
        {   
            if(this.slideService.addOrUpdate(s)==true)
                    return "redirect:/admin/quanly-slide";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/quanly-slide/sua-slide/{"+s.getId().toString()+"}" ;
    }
    
}
