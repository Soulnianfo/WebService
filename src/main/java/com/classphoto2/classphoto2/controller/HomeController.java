/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.controller;

import com.classphoto2.classphoto2.DTO.UserDTO;
import com.classphoto2.classphoto2.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import com.classphoto2.classphoto2.repository.UserRepository;
import com.classphoto2.classphoto2.service.UserService;
import com.google.inject.internal.Errors;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Souleymane
 */
@Controller

public class HomeController {
    @Autowired
    UserRepository userRepo;
    @Autowired UserService service;
    
    @ApiOperation(value = "Create a school account",response = Iterable.class)
    @GetMapping("/registration")
    public String registreForm(WebRequest request, Model model) {
        model.addAttribute("userdto", new UserDTO());
        return "registreForm";
    }

    @GetMapping("/")
    public String redirLogin(WebRequest request, Model model) {
        model.addAttribute("userdto", new UserDTO());
        return "redirect: /login";
    }

    @GetMapping("/login")
    public String login(){
        
        return "login";
    }
    
    @PostMapping("/login")
    public String loginCheck(){
         System.out.println("ICI :");
        return "Success";
    }
    
   
    
    
    @RequestMapping(method=RequestMethod.POST,  path = "/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registre(@ModelAttribute("userdto") @Valid UserDTO user) {
    	
            createUserAccount(user);
      
        
        return "redirect:/login";
    }
    private void createUserAccount(UserDTO accountDto) {
	        System.out.println(" 1");

        int registered = 0;
        
        registered = service.CreateNewUser(accountDto);
        
        
       
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/access-denied";
    }

}
