/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.service;

import com.classphoto2.classphoto2.DTO.ChildDTO;
import com.classphoto2.classphoto2.DTO.UserDTO;
import com.classphoto2.classphoto2.model.Address;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.model.Users;
import com.classphoto2.classphoto2.repository.AddressRepository;
import com.classphoto2.classphoto2.repository.ChildrenRepositorie;
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
     
    @Autowired
    ChildrenRepositorie repochild;
    
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
        school.setName(userdto.getName());
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

    @Override
    public Children CreateNewChild(ChildDTO dto) {
        if (emailExist(dto.getEmail())) {   
         throw new UnsupportedOperationException("Cette adresse mail eiste déjà.");
       }
        System.out.println(" Child ");
       Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMatchingPassword(dto.getMatchingPassword());
        user.setUsername(dto.getUsername());
        user.setRole("USER");
        
        Children child = new Children();
        child.setClassesId(dto.getClassesId());
        child.setFirstName(dto.getFirstName());
        child.setLastName(dto.getLastName());
        child.setEmail(dto.getEmail());
      
        Address address = new Address();
        address.setCodePostale(dto.getCodePostale());
        address.setNumero(dto.getNumero());
        address.setVille(dto.getVille());
        address.setRue(dto.getRue());
        user.setAddress(address);
    
        repo.save(user);
        return repochild.save(child);
    }
    
    
}
