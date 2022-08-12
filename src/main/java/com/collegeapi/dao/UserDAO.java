package com.collegeapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public UserModel getByEmail(String email) throws SQLException{
		String sql = "select * from college_user where email = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, email);
		ResultSet rs = pstm.executeQuery();
		
		UserModel user = new UserModel();
		
		while(rs.next()) {
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
		}
		
		rs.close();
		pstm.close();
		
		return user;
	}

}
