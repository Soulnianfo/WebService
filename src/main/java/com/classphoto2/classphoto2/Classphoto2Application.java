package com.classphoto2.classphoto2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.classphoto2.classphoto2.service.StorageService;

@SpringBootApplication

public class Classphoto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Classphoto2Application.class, args);
	}
	
}

