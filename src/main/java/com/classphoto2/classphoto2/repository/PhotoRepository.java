package com.classphoto2.classphoto2.repository;

import org.springframework.data.repository.CrudRepository;

import com.classphoto2.classphoto2.model.Photos;

public interface PhotoRepository extends CrudRepository<Photos, Integer> {

}
