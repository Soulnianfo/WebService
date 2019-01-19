package com.classphoto2.classphoto2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.classphoto2.classphoto2.model.Photographers;
import com.classphoto2.classphoto2.model.Schooladmins;

public interface PhotographRepository extends CrudRepository<Photographers, Integer> {

	 @Query("SELECT u FROM Photographers u WHERE u.email= ?1")
	 Photographers findByEmail(String email);

}
