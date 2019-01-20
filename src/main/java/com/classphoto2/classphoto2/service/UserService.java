/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classphoto2.classphoto2.service;

import com.classphoto2.classphoto2.DTO.ChildDTO;
import com.classphoto2.classphoto2.DTO.UserDTO;
import com.classphoto2.classphoto2.DTO.parentDTO;
import com.classphoto2.classphoto2.controller.PhotographController;
import com.classphoto2.classphoto2.model.Address;
import com.classphoto2.classphoto2.model.Children;
import com.classphoto2.classphoto2.model.Genre;
import com.classphoto2.classphoto2.model.Parents;
import com.classphoto2.classphoto2.model.ParentsChildren;
import com.classphoto2.classphoto2.model.Photographers;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.model.Users;
import com.classphoto2.classphoto2.repository.AddressRepository;
import com.classphoto2.classphoto2.repository.ChildrenRepositorie;
import com.classphoto2.classphoto2.repository.GenreRepo;
import com.classphoto2.classphoto2.repository.ParentChildrenRepo;
import com.classphoto2.classphoto2.repository.ParentRepo;
import com.classphoto2.classphoto2.repository.PhotographRepository;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.repository.UserRepository;

import java.util.List;
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
    ParentChildrenRepo repoParentChild;
    @Autowired
    ParentRepo repoParent;
    @Autowired
    SchooladminRepository repoSchool;
    @Autowired
    AddressRepository repoAddress;
    @Autowired
    PhotographRepository repophotograph;
    @Autowired
    ChildrenRepositorie repochild;
    
    @Autowired
    GenreRepo genreRepo;
    
    @Autowired
    MyUserDetailService service;
    
    @Override
    public int CreateNewUser(UserDTO userdto) {
        
        if (emailExist(userdto.getEmail())) {   
          return -1;
       }
       Users user = new Users();
       System.out.println(" 2");
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
        
        service.saveUserComputingDerivedPassword(user, user.getPassword());
        return 0;
       
    }
    
    private boolean emailExist(String email){
      Users user = repo.findByEmail(email);
      
        if (user != null) {
            return true;
        }
        return false;
    }
    
    public Parents CreateNewParent(parentDTO dto) {
        if (emailExist(dto.getEmail())) {   
         throw new UnsupportedOperationException("Cette adresse mail eiste déjà.");
       }
        System.out.println(" Parent 1 ");
      
     
       
       Parents parent = new Parents();
       System.out.println("parent first Name "+dto.getFirstName());
       System.out.println("parent last Name "+dto.getLastName());

       parent.setFirstName(dto.getFirstName());
       parent.setLastName(dto.getLastName());
       parent.setEmail(dto.getEmail());
       
      
       Parents par = repoParent.save(parent);
       
       System.out.println("parent registred !!!");
       //ParentsChildren parentChild = new ParentsChildren();
       
       ParentsChildren parentsChild = new ParentsChildren();
       parentsChild.setChildId(repochild.findOneById(dto.getChildId().getId()));
       parentsChild.setParentId(par);
       repoParentChild.save(parentsChild);
        
       System.out.println(" Parent 2 ");
       
      
        Address address = new Address();
        address.setCodePostale(dto.getCodePostale());
        address.setNumero(dto.getNumero());
        address.setVille(dto.getVille());
        address.setRue(dto.getRue());
        
        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMatchingPassword(dto.getMatchingPassword());
        user.setUsername(dto.getUsername());
        user.setRole("USER");
        user.setAddress(address);
        service.saveUserComputingDerivedPassword(user,user.getPassword());
        //repo.save(user);
        return par;
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
        service.saveUserComputingDerivedPassword(user,user.getPassword());
        //repo.save(user);
        return repochild.save(child);
    }
    
    
    @Override
    public Photographers CreateNewPhotograph(ChildDTO dto ) {
        if (emailExist(dto.getEmail())) {   
         throw new UnsupportedOperationException("Cette adresse mail eiste déjà.");
       }
        System.out.println(" Child ");
       Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMatchingPassword(dto.getMatchingPassword());
        user.setUsername(dto.getUsername());
        user.setRole("PHOTOG");
        
        Photographers photograph = new Photographers();
       
        photograph.setFirstName(dto.getFirstName());
        photograph.setLastName(dto.getLastName());
        photograph.setEmail(dto.getEmail());
       
        Address address = new Address();
        address.setCodePostale(dto.getCodePostale());
        address.setNumero(dto.getNumero());
        address.setVille(dto.getVille());
        address.setRue(dto.getRue());
        user.setAddress(address);
        
        service.saveUserComputingDerivedPassword(user,user.getPassword());
      
        return repophotograph.save(photograph);
    }
    
    
}
