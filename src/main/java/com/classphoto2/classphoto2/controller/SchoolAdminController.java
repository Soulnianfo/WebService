/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.controller;

import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.ParentsChildren;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.ChildrenRepositorie;
import com.classphoto2.classphoto2.repository.ParentChildrenRepo;
import com.classphoto2.classphoto2.repository.ParentRepo;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
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
    @Autowired
	 ChildrenRepositorie repochild;
    @Autowired
	 ParentRepo repoParent;

	 @Autowired
	 ParentChildrenRepo repochildParnt;
    
    @GetMapping("/accueilSchool")
    private String accueil(Model model,Authentication auth ){
        
        if(userDetailsService.userCt.getRole().equals("ADMIN")){
            
            model.addAttribute("school",repo.findByEmail(userDetailsService.userCt.getEmail()));
            return "accueilSchool";
        }
        if(userDetailsService.userCt.getRole().equals("USER")){
        	
        	  java.util.List<ParentsChildren> col = repochildParnt.findAllByparentId(repoParent.findByFirstName(auth.getName()));
        	  java.util.List<Children>listChild = new ArrayList();
   	       for (ParentsChildren e: col) {
   	          
   	           listChild.add(repochild.findOneById(e.getChildId().getId()));
   	           
   	     
   	    	  
   	       }
   	       
   	 
   	    model.addAttribute("listChild",listChild);
            return "parentAccueil";
        }
        if(userDetailsService.userCt.getRole().equals("PHOTOG")){
           
            return "redirect:/photograph";
        }
        
      return "";
    }
    
}
