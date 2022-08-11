package com.collegeapi.controller;

import com.collegeapi.dao.UserDAO;
import com.collegeapi.model.UserModel;

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
}
