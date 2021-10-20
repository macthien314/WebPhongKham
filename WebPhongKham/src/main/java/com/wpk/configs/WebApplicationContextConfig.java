/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.configs;



import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wpk.formatter.MedicalFormatter;
import com.wpk.validator.AppointmentValidator;
import com.wpk.validator.DoctorValidator;
import com.wpk.validator.DrugValidator;
import com.wpk.validator.MedicalExaminationCardValidator;
import com.wpk.validator.MedicalValidator;
import com.wpk.validator.NurseValidator;
import com.wpk.validator.PatientValidator;
import com.wpk.validator.PrescriptionValidator;
import com.wpk.validator.ServiceInvoiceValidator;
import com.wpk.validator.SlideValidator;
import com.wpk.validator.UserImageValidator;
import com.wpk.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author macth
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.wpk.controllers",
    "com.wpk.repository",
    "com.wpk.service",
    "com.wpk.validator"
})
@EnableTransactionManagement
public class WebApplicationContextConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
    }
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resource = new InternalResourceViewResolver();
        resource.setViewClass(JstlView.class);
        resource.setPrefix("/WEB-INF/jsp/");
        resource.setSuffix(".jsp");
        
        return resource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/vendor/**").addResourceLocations("/resources/vendor/");
    }
    
     @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
       
        v.setValidationMessageSource(messageSource());
        return v;
    }
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        return source;
    }
    @Override
    public Validator getValidator() {
        return validator();
    }
    @Bean
    public WebAppValidator userValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new UserImageValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    }
    @Bean
    public WebAppValidator slideValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new SlideValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    }
    @Bean
    public WebAppValidator medicalValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new MedicalValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    }
    @Bean
    public WebAppValidator doctorValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new DoctorValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    }
    
    @Bean
    public WebAppValidator nurseValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new NurseValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    }
    @Bean
    public WebAppValidator drugValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new DrugValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    }
    
        @Bean
    public WebAppValidator patientValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new PatientValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    
    }
    
         @Bean
    public WebAppValidator medicalExaminationCardValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new MedicalExaminationCardValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
       
    }
    
      @Bean
    public WebAppValidator appointmentValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new AppointmentValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    
    }
      @Bean
    public WebAppValidator serviceInvoiceValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new ServiceInvoiceValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    
    }
    
       @Bean
    public WebAppValidator prescriptionValidator(){
        Set<Validator> springValidator = new HashSet<>();
        springValidator.add(new PrescriptionValidator());
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidator);
        return v;
    
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MedicalFormatter());
    }
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary( ObjectUtils.asMap(
                "cloud_name","ikj",
                "api_key","394871958181558",
                "api_secret","G6qa5zI0m9xCPWv0GNFzMtLhBvs",
                "secure",true
                 ));
        return c;
    }
}
