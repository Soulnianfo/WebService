package com.classphoto2.classphoto2.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.classphoto2.classphoto2.DTO.ChildDTO;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Photographers;
import com.classphoto2.classphoto2.model.Photos;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.repository.PhotoRepository;
import com.classphoto2.classphoto2.repository.PhotographRepository;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;
import com.classphoto2.classphoto2.service.ServicePhotos;
import com.classphoto2.classphoto2.service.StorageService;
import com.classphoto2.classphoto2.service.UserService;

@Controller
public class PhotographController {
	public Integer adminId=null;
	@Autowired
	ServicePhotos service;
	
	@Autowired
	PhotoRepository repophoto;
	
	@Autowired
	PhotographRepository repophotograph;
	
	 @Autowired
	 MyUserDetailService userDetailsService;
	 
	 @Autowired
	 SchooladminRepository repo;
	 
	 @Autowired UserService serviceUser;
	    
	
	@GetMapping("/addphotograph")
	public String addphotograph(Model model, @Param("id") Integer adminId) {
		 this.adminId = adminId;
		 ChildDTO photographer = new ChildDTO();
		
		model.addAttribute("photographer", photographer);
		return "photographForm";
	}
	
	 @PostMapping("/registrationPhotograph")
	    public String register(Model model, ChildDTO dto){
	       Schooladmins admin = repo.findByEmail(userDetailsService.userCt.getEmail());
	       Photographers photograph = null;
	       List<Schooladmins> ads = new ArrayList();
	       ads.add(admin);
	       photograph = serviceUser.CreateNewPhotograph(dto,ads);
	       model.addAttribute("school",admin);
	        return "/accueilSchool";
	    }
	
	@GetMapping("/photograph")
	public String accueil(Model model) throws IOException {
		Photographers photograph = repophotograph.findByEmail(userDetailsService.userCt.getEmail());
		
		model.addAttribute("photograph", photograph);
		
		model.addAttribute("photos", repophoto.findAll().iterator());
		
		return "accueillPhotograph";
	}
	
	
	
	@PostMapping("/addphoto")
	public String addphotos(@RequestParam("files") MultipartFile[] files) throws IOException {
		int i;
		for(i=0;i<files.length;i++) {
			System.out.println("photos");
			service.add(files[i]);
		}
		
		return "redirect:/photograph";
	}
	
	 @RequestMapping(value = "/image-response-entity/{id}", method = RequestMethod.GET)
	    public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable final Integer id) {
	        HttpHeaders headers = new HttpHeaders();
	       
	        Photos photo = service.get(id);
	        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	         
	        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(photo.getData(), headers, HttpStatus.OK);
	        
	        return responseEntity;
	    }
}
