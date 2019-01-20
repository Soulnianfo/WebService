package com.classphoto2.classphoto2.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Parents;
import com.classphoto2.classphoto2.model.ParentsChildren;

public interface ParentChildrenRepo extends  CrudRepository<ParentsChildren,Integer>{

	ParentsChildren save(ParentsChildren parentsChild);
	List<ParentsChildren> findAllByparentId(Parents id);
    
}
