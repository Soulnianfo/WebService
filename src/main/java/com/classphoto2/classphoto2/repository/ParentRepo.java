package com.classphoto2.classphoto2.repository;

import org.hibernate.annotations.Parent;
import org.springframework.data.repository.CrudRepository;

import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Parents;


public interface ParentRepo extends CrudRepository<Parents, Integer> {
	Parents findByFirstName(String firstName );
}    

