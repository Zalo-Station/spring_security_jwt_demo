package com.xyz.userservice;

import com.xyz.userservice.domain.Role;
import com.xyz.userservice.domain.User;
import com.xyz.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john", "password123", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "password123", new ArrayList<>()));
			userService.saveUser(new User(null, "Martin Matthew", "martin", "password123", new ArrayList<>()));
			userService.saveUser(new User(null, "Mark Eliezer", "mark", "password123", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("martin", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("mark", "ROLE_ADMIN");
		};
	}

}
