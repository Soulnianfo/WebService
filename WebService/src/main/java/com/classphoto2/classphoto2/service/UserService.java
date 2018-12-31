/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.service;

import com.classphoto2.classphoto2.DTO.UserDTO;
import com.classphoto2.classphoto2.model.Address;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.model.Users;
import com.classphoto2.classphoto2.repository.AddressRepository;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.repository.UserRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import static org.eclipse.persistence.config.ExclusiveConnectionMode.Transactional;
import static org.eclipse.persistence.sessions.server.ConnectionPolicy.ExclusiveMode.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Souleymane
 */
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    UserRepository repo;
    @Autowired
    SchooladminRepository repoSchool;
    @Autowired
    AddressRepository repoAddress;
    @Override
    public Users CreateNewUser(UserDTO userdto) {
        
        if (emailExist(userdto.getEmail())) {   
          return null;
       }
       Users user = new Users();
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setMatchingPassword(userdto.getMatchingPassword());
        user.setUsername(userdto.getUsername());
        user.setRole("ADMIN");
        Schooladmins school = new Schooladmins();
        school.setEmail(userdto.getEmail());
        repoSchool.save(school);
        
        Address address = new Address();
        address.setCodePostale(userdto.getCodePostale());
        address.setNumero(userdto.getNumero());
        address.setVille(userdto.getVille());
        address.setRue(userdto.getRue());
        user.setAddress(address);
        return repo.save(user);
    }
    
    private boolean emailExist(String email){
      Users user = repo.findByEmail(email);
      
        if (user != null) {
            return true;
        }
        return false;
    }
    
    
}
