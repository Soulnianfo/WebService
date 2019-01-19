package com.classphoto2.classphoto2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication

public class Classphoto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Classphoto2Application.class, args);
	}
	
}

