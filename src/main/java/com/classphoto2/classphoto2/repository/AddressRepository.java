/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.repository;

import com.classphoto2.classphoto2.model.Address;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Souleymane
 */
public interface AddressRepository extends CrudRepository<Address,Integer> {
    
}
