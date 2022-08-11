package com.collegeapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.collegeapi.model.UserModel;

import connectionfactory.ConnectionFactory;

public class UserDAO {
	
	private Connection con;

	public UserDAO() {
		this.con = new ConnectionFactory().connect();
	}
	
	public void post(UserModel user) throws SQLException {
		String sql = "insert into college_user(username, password, email) values (?,?,?)";
		PreparedStatement pstm = con.prepareStatement(sql);
		
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getPassword());
		pstm.setString(3, user.getEmail());
		
		pstm.execute();
		pstm.close();
		
	}

}
