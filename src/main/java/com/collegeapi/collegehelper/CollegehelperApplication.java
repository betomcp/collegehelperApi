package com.collegeapi.collegehelper;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collegeapi.controller.UserController;
import com.collegeapi.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootApplication
@RestController
public class CollegehelperApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CollegehelperApplication.class, args);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/collegeapi")
	public String tryLogin(@RequestParam(value = "email", defaultValue = "salve") String email) throws JsonProcessingException, SQLException {
		return new UserController().getUserByEmail(email);
		//return email;
	}

}
