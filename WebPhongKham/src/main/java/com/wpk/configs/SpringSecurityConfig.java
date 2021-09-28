/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages={
    "com.wpk.repository",
    "com.wpk.service"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        
        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
        
        http.logout().logoutSuccessUrl("/login");
        http.exceptionHandling().accessDeniedPage("/login?accessDinied");
        //cấu hình User duoc phep truy cap
        http.authorizeRequests().antMatchers("/").permitAll()
               
                .antMatchers("/admina/**").access("hasRole('ROLE_ADMIN')").and()
                .sessionManagement().maximumSessions(1);
        http.csrf().disable();
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
