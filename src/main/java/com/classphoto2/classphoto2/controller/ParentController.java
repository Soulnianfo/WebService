package com.classphoto2.classphoto2.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.classphoto2.classphoto2.DTO.ChildDTO;
import com.classphoto2.classphoto2.DTO.parentDTO;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Parents;
import com.classphoto2.classphoto2.model.ParentsChildren;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.ChildrenRepositorie;
import com.classphoto2.classphoto2.repository.ParentChildrenRepo;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;
import com.classphoto2.classphoto2.service.UserService;
import com.google.inject.spi.Element;

import antlr.collections.List;

@Controller
public class ParentController {
	
	 @Autowired
	 ChildrenRepositorie repochild;
	 

	 @Autowired
	 ParentChildrenRepo repochildParnt;
	 
	 @Autowired 
	 UserService service;
	 @Autowired
	 SchooladminRepository repo;

	 @Autowired
	    MyUserDetailService userDetailsService;
	 @GetMapping("/addParent")
	    public String form(Model model){
	        model.addAttribute("parentdto", new parentDTO());
	        model.addAttribute("childrens",repochild.findAll() );
	        return "formParent";
	    }
	 
	 @PostMapping("/registrationParent")
	    public String register(Model model, parentDTO dto){
	     //  Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
	       Parents parent = null;
	       Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
	   
	       parent = service.CreateNewParent(dto);
	     
	       model.addAttribute("school",admin);
	        return "/accueilSchool";
	    }
}
