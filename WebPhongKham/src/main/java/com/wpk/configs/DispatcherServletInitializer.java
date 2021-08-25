/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author macth
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

     @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
           HibernateConfig.class,
           TilesConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
      return new Class[]{
          WebApplicationContextConfig.class
      };
    }

    @Override
    protected String[] getServletMappings() {
      return new String[] {"/"};
    }
    
}
