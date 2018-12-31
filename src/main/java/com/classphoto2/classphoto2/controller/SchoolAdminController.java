/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.controller;

import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Souleymane
 */
@Controller
@RequestMapping("/school")
public class SchoolAdminController {
    
    @Autowired
    SchooladminRepository repo;
    @Autowired
    MyUserDetailService userDetailsService;
    
    @GetMapping("/accueilSchool")
    private String accueil(Model model){
        
        if(userDetailsService.userCt.getRole().equals("ADMIN")){
            
             model.addAttribute("school",repo.findByEmail(userDetailsService.userCt.getEmail()));
             System.out.println(" name "+repo.findByEmail(userDetailsService.userCt.getEmail()).getName());
            return "accueilSchool";
        }
        if(userDetailsService.userCt.getRole().equals("USER")){
            return "parent";
        }
        if(userDetailsService.userCt.getRole().equals("PHOTO")){
            return "photograph";
        }
      return "";
    }
    
}
