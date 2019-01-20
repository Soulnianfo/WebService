/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.controller;

import com.classphoto2.classphoto2.model.Classes;
import com.classphoto2.classphoto2.model.Photos;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.ClassesRepository;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;
import com.classphoto2.classphoto2.service.ServicePhotos;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.InputStream;
import java.util.List;

import org.hibernate.annotations.Parent;
import org.json.simple.JSONObject;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    ClassesRepository repoClasse;
    @Autowired
    MyUserDetailService userDetailsService;
    
    @Autowired
    SchooladminRepository schoolRepo;
    
    @Autowired
	ServicePhotos service;
	
      
    
    @ApiOperation(value = "View a list of avaible school classes",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of classes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method=RequestMethod.GET , path="/getAllClass",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Classes> getAllClass(@Param("id") Integer id){
        
	        
       return repoClasse.getAllClass(schoolRepo.findByEmail(userDetailsService.userCt.getEmail()));         
    }
    
    @ApiOperation(value = "View a list of avaible school class photos",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of class photos"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method=RequestMethod.GET , path="/getClassPhotos",produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONObject getClassPhotos(@Param("id") Integer id){
         Optional<Classes> cl = repoClasse.findById(id);
        JSONObject obj = new JSONObject();
	        obj.put("photos", cl.get().getPhotosCollection());
	        obj.put("children",cl.get().getChildrenCollection());
       
	        
       return obj ;         
    }
     
    @ApiOperation(value = "View a photo by it\'s id",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved of photo"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/image-response-entity/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable final Integer id) {
        HttpHeaders headers = new HttpHeaders();
       
        Photos photo = service.get(id);
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
         
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(photo.getData(), headers, HttpStatus.OK);
        System.out.println("ok");
        return responseEntity;
    }
}
