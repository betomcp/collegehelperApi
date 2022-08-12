package com.collegeapi.controller;

import java.sql.SQLException;

import com.collegeapi.dao.UserDAO;
import com.collegeapi.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class UserController {

	private UserDAO useerDao;
	
	public UserController() {
		this.useerDao = new UserDAO();
	}
	
	public String postUser(UserModel user) {
		try {
			this.useerDao.post(user);			
			return "dados salvos com sucesso!";
		}catch(Exception e) {
			e.printStackTrace();
			return "!!erro!!";
		}	
	}
	
	public String getUserByEmail(String email) throws JsonProcessingException, SQLException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(this.useerDao.getByEmail(email));
	}
	
}
