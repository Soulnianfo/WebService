/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.controller;

import com.classphoto2.classphoto2.DTO.ChildDTO;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.ChildrenRepositorie;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;
import com.classphoto2.classphoto2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Souleymane
 */
@Controller
public class ChildrenController {
    @Autowired
    MyUserDetailService userDetailsService;
    @Autowired
    SchooladminRepository repo;
    @Autowired UserService service;
    @Autowired
    ChildrenRepositorie repochild;
    @GetMapping("/child")
    public String form(Model model){
        model.addAttribute("childdto", new ChildDTO());
        model.addAttribute("classes", repo.findByEmail(userDetailsService.userCt.getEmail()).getClassesCollection());
        return "formChild";
    }
    
    @PostMapping("/registrationChild")
    public String register(Model model, ChildDTO dto){
       Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
       Children child = null;
       
       child = service.CreateNewChild(dto);
       model.addAttribute("school",admin);
        return "/accueilSchool";
    }
    
}
