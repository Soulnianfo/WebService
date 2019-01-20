package com.classphoto2.classphoto2.repository;

import org.springframework.data.repository.CrudRepository;

import com.classphoto2.classphoto2.model.Genre;


public interface GenreRepo  extends CrudRepository<Genre,Integer>{

	Genre save(Genre genre);

}
