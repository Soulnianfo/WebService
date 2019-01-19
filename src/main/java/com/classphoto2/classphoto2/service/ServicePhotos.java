package com.classphoto2.classphoto2.service;



import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.classphoto2.classphoto2.model.Photos;
import com.classphoto2.classphoto2.repository.PhotoRepository;
import com.classphoto2.classphoto2.repository.PhotographRepository;
import com.classphoto2.classphoto2.repository.TypephotoRepository;

@Service
public class ServicePhotos {

	final String proprietairePhoto = null;
	final Integer proprietaireId = -1;
	
	@Autowired
	PhotoRepository repo;
	
	@Autowired
	PhotographRepository repoPhotograph;
	
	@Autowired
	TypephotoRepository repophototype;
	
	public Photos add(MultipartFile file) throws IOException {
		
		Photos photo = new Photos();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		photo.setLabel(fileName);
		photo.setFiletype(file.getContentType());
		photo.setData(file.getBytes());
		photo.setDateTake(new Date());
		photo.setType(repophototype.findById(1).get());
		
		photo.setPhotographId(repoPhotograph.findById(1).get());
		
		return repo.save(photo);
	}
	
	public Photos get(Integer id) {
		
		return repo.findById(id).get();
	}
}
