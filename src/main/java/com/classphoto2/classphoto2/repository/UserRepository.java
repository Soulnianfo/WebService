/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.repository;

import com.classphoto2.classphoto2.model.Users;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Souleymane
 */
public interface UserRepository extends CrudRepository<Users,Integer>{

    public Users findByEmail(String email);

    public Users findByUsername(String username);

   
    
}
