/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.service;

import com.classphoto2.classphoto2.model.Users;
import com.classphoto2.classphoto2.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Souleymane
 */
@Service
public class MyUserDetailService implements UserDetailsService{
    @Autowired
    UserRepository repo;
    public final PasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public final Users userCt = new Users();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("User name : "+username);
      
        Users user = repo.findByUsername(username);
        userCt.setUsername(user.getUsername());
        userCt.setRole(user.getRole());
        userCt.setEmail(user.getEmail());
        userCt.setId(user.getId());
        if (user == null) {
            throw new UsernameNotFoundException(
              "No user found with username: "+ username);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<String> roles = new ArrayList<>();
        roles.add(user.getRole());
        return  new org.springframework.security.core.userdetails.User
          (user.getUsername(),
          encoder.encode(user.getPassword()),
          enabled, accountNonExpired, 
          credentialsNonExpired,
          accountNonLocked, 
          getAuthorities(roles)
          );
        //encoder.encode("azerty1");
        //return new org.springframework.security.core.userdetails.User("user",encoder.encode("azerty1"),true,true,true,true,getAuthorities(roles));
    }
    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

   
    
}
