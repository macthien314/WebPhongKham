/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.controllers;

import com.wpk.pojos.Slide;
import com.wpk.service.SlideService;
import static com.wpk.utils.util.isNumeric;
import com.wpk.validator.WebAppValidator;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.http.protocol.HTTP;
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
        String title = params.getOrDefault("title", "");
        String active = params.getOrDefault("active", "all");
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
        
        model.addAttribute("slides", this.slideService.getSlides(title,active,pageQuan, page));
        model.addAttribute("count", this.slideService.countSlide(title,active));
        
        model.addAttribute("page", Integer.toString(page));
        model.addAttribute("active", active);
        model.addAttribute("pagequan",pageQuan);
        model.addAttribute("title", title);
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
             if(s.getActive() != true)
                s.setActive(false);
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
            if(s.getActive() != true)
                s.setActive(false);
            if(this.slideService.addOrUpdate(s)==true)
                    return "redirect:/admin/quanly-slide";
        else
                model.addAttribute("err","Something wrong");
        }
        
        return "redirect:/admin/quanly-slide/sua-slide/{"+s.getId().toString()+"}" ;
    }
    
}
