package com.School_Managment_System.School_Managment_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SchoolManagmentSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolManagmentSystemApplication.class, args);
	}

}
