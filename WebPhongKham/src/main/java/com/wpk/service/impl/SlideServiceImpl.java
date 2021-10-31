/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.pojos.Slide;
import com.wpk.repository.SlideRepository;
import com.wpk.service.SlideService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class SlideServiceImpl implements SlideService{
    @Autowired
    private SlideRepository slideRepository;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public List<Slide> getSlides(int page, String quantity) {
        
        return this.slideRepository.getSlides(page,quantity);
    }

    @Override
    public Slide getSlideByID(int slideID) {
        return this.slideRepository.getSlideByID(slideID);
    }

    @Override
    public boolean addOrUpdate(Slide slide) {
        if(!slide.getFile().isEmpty()){
        try {
          
            Map r = this.cloudinary.uploader().upload(slide.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","slide"));
            slide.setImage((String) r.get("secure_url"));
        } catch (IOException ex) {
            System.out.println("==ADD USER==");
        }}
        return this.slideRepository.addOrUpdate(slide);
    }

    @Override
    public boolean removeSlide(int id) {
        return this.slideRepository.removeSlide(id);
    }

    @Override
    public List<Slide> getSlides(String title, String active,String pageQuan, int pageNum) {
        return this.slideRepository.getSlides(title, active,pageQuan,pageNum);
    }

    @Override
    public long countSlide(String kw, String active) {
        return this.slideRepository.countSlide(kw, active);
    }
   
}
