/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service;

import com.wpk.pojos.Slide;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface SlideService {
    List<Slide> getSlides(int kw, String quatity);

    Slide getSlideByID(int slideID);
    boolean addOrUpdate(Slide slide);
    boolean removeSlide(int id);
    List<Slide> getSlides(String kw, String active,String pageQuan, int pageNum);
    long countSlide(String kw, String active);
}
