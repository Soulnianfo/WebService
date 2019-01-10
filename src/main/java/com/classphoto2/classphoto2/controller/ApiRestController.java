/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.controller;

import com.classphoto2.classphoto2.model.Classes;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import java.util.List;
import org.json.simple.JSONObject;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Souleymane
 */
@RestController
@RequestMapping("/api")
public class ApiRestController {
    @Autowired
    SchooladminRepository repoSchool;
    
    //@GetMapping("/getAllClass")
    @RequestMapping(method=RequestMethod.GET , path="/getAllClass",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Classes> getAllClass(@Param("id") Integer id){
        //JSONObject obj = new JSONObject();
       // System.out.println("This ID :"+id);
        Optional<Schooladmins> school = repoSchool.findById(id);
	  //  obj.put("classes", school.get().getClassesCollection());
	        
       return (List<Classes>) school.get().getClassesCollection();         
    }
            
}
