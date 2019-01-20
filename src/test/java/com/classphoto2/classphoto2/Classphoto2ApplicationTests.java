package com.classphoto2.classphoto2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.classphoto2.classphoto2.DTO.UserDTO;
import com.classphoto2.classphoto2.model.Parents;
import com.classphoto2.classphoto2.model.Schooladmins;
import com.classphoto2.classphoto2.model.Users;
import com.classphoto2.classphoto2.repository.ParentRepo;
import com.classphoto2.classphoto2.repository.SchooladminRepository;
import com.classphoto2.classphoto2.repository.UserRepository;
import com.classphoto2.classphoto2.service.MyUserDetailService;
import com.classphoto2.classphoto2.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Classphoto2ApplicationTests {

		
		@Autowired
		 SchooladminRepository schoolRrepo;
		
		@Autowired
		 UserRepository userRrepo;
		
	    @Autowired 
	    UserService service;

	    @Autowired
	    MyUserDetailService serviceUser;
	    
	    @Autowired
	    ParentRepo parentRepo;
	    
	    
		
		
		@Test
		public void contextLoads() {
			Schooladmins school = new Schooladmins();
			UserDTO user = new UserDTO();
			Parents parent = new Parents();
			
			parent.setEmail("parent@gmail.com");
			parent.setFirstName("parent");
			parent.setLastName("parent");
		//	parentRepo.save(parent);
		
			
			school.setName("CM2");
			school.setEmail("cm2@gmail.com");
			schoolRrepo.save(school);
			
			user.setEmail("user.email@gmail.com");
			user.setPassword("user");
			user.setMatchingPassword("user");
			user.setUsername("user");
			user.setName("userName");
			user.setVille("Saint Etienne");
			user.setCodePostale(42000);
			//service.CreateNewUser(user);
			
		/*	assertThat("parent")
		      .isEqualTo(parentRepo.findByFirstName("parent").getFirstName());*/
			
			/*assertThat("user")
		      .isEqualTo(serviceUser.loadUserByUsername("user").getUsername());*/
			
			assertThat("CM2")
		      .isEqualTo(schoolRrepo.findByEmail("cm2@gmail.com").getName());
		}
}

