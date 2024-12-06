package com.foodApp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Connect.Connect;
import com.foodApp.DAO.MenuDao;
import com.foodApp.modules.Menu;

public class MenuDaoImpl implements MenuDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status;
	private List<Menu>menuList=null;
	
	private static final String  ADD_MENU_QUERY="insert into menu ( restaurantId, menuName,price,description,isAvailable,imgPath) values(?,?,?,?,?,?)";
	private static final String  GET_ALL_MENU_QUERY="select * from menu where restaurantId=?";
	private static final String  GET_MENU_QUERY="select * from menu where menuId=?";
	private static final String  UPDATE_QUERY="update menu set restaurantId=?, menuName=?,price=?,description=?,isAvailable=?,imgPath=? where menuId= ?";
	private static final String  DELETE_QUERY="delete from menu where menuId=?";
	
	public MenuDaoImpl(){
		
		con=Connect.getConnect();	
		
	}

	@Override
	public int addMenu(Menu m) {
		
		try {
			pstmt=con.prepareStatement(ADD_MENU_QUERY);
			pstmt.setInt(1,m.getRestaurantId());
			pstmt.setString(2,m.getMenuName());
			pstmt.setFloat(3,m.getPrice());
			pstmt.setString(4,m.getDescription());
			pstmt.setBoolean(5,m.isAvailable());
			pstmt.setString(6,m.getImgPath());
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return status;
	}

	@Override
	public List getAllMenu(int restaurantId){
		try {
			pstmt=con.prepareStatement(GET_ALL_MENU_QUERY);
			pstmt.setInt(1, restaurantId);
			res=pstmt.executeQuery();
			menuList=new ArrayList<Menu>();
			while(res.next()) {
				int menuId=res.getInt("menuId");
				//int restaurantId=res.getInt("restaurantId");
				String menuName=res.getString("menuName");
				String description=res.getString("description");
				float price=res.getFloat("price");
				boolean isAvailable=res.getBoolean("isAvailable");
				String imgPath=res.getString("imgPath");
				Menu menu = new Menu(menuId,restaurantId, menuName, price, description, isAvailable, imgPath);
				menuList.add(menu);	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
		
	}

	@Override
	public Menu getMenu(int menuId) {
		Menu menu=null;
		try {
			pstmt=con.prepareStatement(GET_MENU_QUERY);
			pstmt.setInt(1,menuId);
			res=pstmt.executeQuery();
			res.next();
			int restaurantId=res.getInt("restaurantId");
			String menuName=res.getString("menuName");
			float price=res.getFloat("price");
			String description=res.getString("description");
			boolean isAvailable=res.getBoolean("isAvailable");
			String imgPath=res.getString("imgPath");
		    menu = new Menu(restaurantId, menuName, price, description, isAvailable, imgPath);
		  		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public int updateMenu(Menu m) {
		  try {
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1,m.getRestaurantId());
			pstmt.setString(2,m.getMenuName());
			pstmt.setFloat(3,m.getPrice());
			pstmt.setString(4,m.getDescription());
			pstmt.setBoolean(5,m.isAvailable());
			pstmt.setString(6,m.getImgPath());
			pstmt.setInt(7,m.getMenuId());
			status=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}

	@Override
	public int deleteMenu(int menuId) {
		
		try {
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, menuId);
			status=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}