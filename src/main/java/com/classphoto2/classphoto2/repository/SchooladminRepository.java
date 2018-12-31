/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.repository;

import com.classphoto2.classphoto2.model.Schooladmins;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Souleymane
 */
public interface SchooladminRepository extends CrudRepository<Schooladmins,Integer> {
   @Query("SELECT u FROM Schooladmins u WHERE u.email= ?1")
    Schooladmins findByEmail(String email);
}
