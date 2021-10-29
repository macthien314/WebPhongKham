/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wpk.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.ProgressCallback;
import com.cloudinary.utils.ObjectUtils;

import com.wpk.pojos.User;
import com.wpk.repository.UserRepository;
import com.wpk.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private Cloudinary cloudinary; 
    @Override
    public boolean addUser(User user) {
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(password));
        user.setUserRole(User.getUSER());
        if(!user.getFile().isEmpty()){
            try {

                Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type","auto","folder","Doctor"));
                user.setImage((String) r.get("secure_url"));
            } catch (IOException ex) {
                System.out.println("==ADD USER==");
            }
        }
        return this.userRepository.addUser(user);
    }
    @Override
    public boolean addDoctorUser(User user) {
        String password = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(password));
       
        
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUser(String username) {
        return this.userRepository.getUser(username);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.userRepository.getUser(username);
        if(users.isEmpty())
            throw new UsernameNotFoundException("User does not exites");
       
        User u = users.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(u.getUserRole()));
        return new org.springframework.security.core.userdetails.User(u.getUsername(),u.getPassword(), auth);
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }
    
}
