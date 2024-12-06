package com.foodApp.DaoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Connect.Connect;
import com.foodApp.DAO.UserDao;
import com.foodApp.modules.User;

public class UserDaoImpl implements UserDao {
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status;
	private List<User>userList=null;
	
	private static final String  ADD_USER_QUERY="insert into user (userName, email,phoneNumber,password,address) values(?,?,?,?,?)";
	private static final String  GET_ALL_USER_QUERY="select * from user";
	private static final String  GET_USER_QUERY="select * from user where email=?";
	private static final String  UPDATE_QUERY="update user set userName =?,phoneNumber =?,password= ?,address= ? , email= ? where userId=?";
	private static final String  DELETE_QUERY="delete from user where email=?";
	
	public UserDaoImpl() {
		con=Connect.getConnect();	
	}
	

	@Override
	public int addUser(User u) {

		try {
			pstmt=con.prepareStatement(ADD_USER_QUERY);
			pstmt.setString(1,u.getUserName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3,u.getPhoneNumber());
			pstmt.setString(4,u.getPassword());
			pstmt.setString(5,u.getAddress());
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}

	@Override
	public List getAllUser() {
		 try {
			stmt = con.createStatement();
			res=stmt.executeQuery(GET_ALL_USER_QUERY);
			userList=new ArrayList<User>();
			while(res.next()) {
				int userId=res.getInt("userId");
				String userName=res.getString("userName");
				String email=res.getString("email");
				String phoneNumber=res.getString("phoneNumber");
				String password=res.getString("password");
				String address=res.getString("address");
				User user = new User(userId,userName, email, phoneNumber, password, address);
				userList.add(user);	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User getUser(String email) {
		User user=null;
		try {
			pstmt=con.prepareStatement(GET_USER_QUERY);
			pstmt.setString(1, email);
			res=pstmt.executeQuery();
			res.next();
			int userId=res.getInt("userId");
			String userName=res.getString("userName");
			String phoneNumber=res.getString("phoneNumber");
			String password=res.getString("password");
			String address=res.getString("address");
		   user = new User(userId,userName, email, phoneNumber, password, address);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int updateUser(User u) {
		try {
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1,u.getUserName());
			pstmt.setString(2,u.getPhoneNumber());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getAddress());
			pstmt.setString(5,u.getEmail());
			pstmt.setInt(6,u.getUserId());
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteUser(String email) {
	
		try {
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setString(1,email);
			status=pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return status;
	}

}