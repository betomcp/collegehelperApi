package com.collegeapi.collegehelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collegeapi.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootApplication
@RestController
public class CollegehelperApplication {
	
	private UserModel user1;

	public static void main(String[] args) {
		SpringApplication.run(CollegehelperApplication.class, args);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/collegeapi")
	public String tryLogin(@RequestParam(value = "username", defaultValue = "") String name,
			@RequestParam(value = "email", defaultValue = "") String email, 
			@RequestParam(value = "password", defaultValue = "") String password) throws JsonProcessingException {
		
		user1 = new UserModel(name, password, email);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(user1);
		return json;
		//return new UserController().postUser(user1);
	}

}
