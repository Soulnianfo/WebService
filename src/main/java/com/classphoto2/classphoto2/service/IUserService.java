/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.service;

import java.util.List;

import com.classphoto2.classphoto2.DTO.ChildDTO;
import com.classphoto2.classphoto2.DTO.UserDTO;
import com.classphoto2.classphoto2.DTO.parentDTO;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Parents;
import com.classphoto2.classphoto2.model.Photographers;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.model.Users;

/**
 *
 * @author Souleymane
 */
public interface IUserService {
    int CreateNewUser(UserDTO user);
    Children CreateNewChild(ChildDTO dto);
    Photographers CreateNewPhotograph(ChildDTO dto);
	Parents CreateNewParent(parentDTO dto);
}
