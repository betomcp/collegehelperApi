package com.collegeapi.model;

public class UserModel {

	private String name;
	private String password;
	private long id;
	private String email;
	
	public UserModel() {}
	
	public UserModel(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public UserModel(String name, String password, long id, String email) {
		this.name = name;
		this.password = password;
		this.id = id;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
