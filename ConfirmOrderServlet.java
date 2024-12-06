package com.foodApp.Servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.Connect.Connect;
import com.foodApp.DaoImpl.Cart;
import com.foodApp.modules.CartItem;
import com.foodApp.modules.User;

@WebServlet("/confirm")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 LocalDate currentDate = LocalDate.now();
     Date sqlDate = Date.valueOf(currentDate);

   		Connection con = Connect.getConnect();
		String paymentMode = request.getParameter("paymentMethod");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("loginUser");
		int restaurantId= (int) session.getAttribute("restaurantId");
		int userId=user.getUserId();
        float totalAmount=(float) session.getAttribute("total");
        int status=0;
        //insert data into ordertable
		String OrderTableQuery="insert into ordertable(userId,restaurantId,paymentMode,totalAmount,orderDate)values(?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			PreparedStatement statement = con.prepareStatement(OrderTableQuery);
			statement.setInt(1, userId);
			statement.setInt(2, restaurantId);
			statement.setFloat(4, totalAmount);
			statement.setString(3, paymentMode);
			statement.setDate(5, sqlDate);
		    int c=statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int orderId=0;
		//to retrieve the order id from the ordertable to insert data into orderItem  table
		try {
			String query = "SELECT MAX(orderId) FROM ordertable";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			 rs.next();
			 orderId = rs.getInt(1);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//get cartItem to get some data to insert into orderItem table
		Cart cart=(Cart) session.getAttribute("cart");
		 Map<Integer,CartItem>map= cart.getItems();
		 Set<Map.Entry<Integer,CartItem>>set=map.entrySet();
		  
		  for(Map.Entry<Integer,CartItem>cartMap:set){ 
			 // int itemId=cartMap.getKey();
			  int quantity=cartMap.getValue().getQuantity();
			  float subTotal=cartMap.getValue().getSubTotal();
			  String menuName=cartMap.getValue().getMenuName();
			  int menuId;
			  //get menuId from menu by using menuName inorder to insert into orderItem
			  String MenuIdQuery="select * from menu where menuName=?";
			  try {
				PreparedStatement statement = con.prepareStatement(MenuIdQuery);
				statement.setString(1,menuName );
				ResultSet rs = statement.executeQuery();
				 rs.next();
				 menuId = rs.getInt(1);
				 //insert query into orderItem table
				 String OrderItemQuery="insert into orderitem ( orderId, menuId, quantity, subTotal)values(?,?,?,?)";
				 PreparedStatement statement1 = con.prepareStatement(OrderItemQuery);
				 //statement1.setInt(1, itemId);
				 statement1.setInt(1, orderId);
				 statement1.setInt(2, menuId);
				 statement1.setInt(3, quantity);
				 statement1.setFloat(4, subTotal);
				 int status2=statement1.executeUpdate();

				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			  
		
		   }
		  
		  //insert data into OrderHistory table
		  String orderHistoryQuery="insert into orderhistory(orderId, userId, totalAmount,orderDate) values(?,?,?,?)";
		 		  try {
			PreparedStatement statement2 = con.prepareStatement(orderHistoryQuery);
			statement2.setInt(1, orderId);
			statement2.setInt(2, userId);
			statement2.setFloat(3, totalAmount);
			statement2.setDate(4, sqlDate);
			 status=statement2.executeUpdate();
			System.out.println("All Set Success");
			con.commit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	if(status!=0) {
		session.setAttribute("cart",null );
		response.sendRedirect("orderSuccess.jsp");
		
	}
	else {
		response.sendRedirect("orderFailed.jsp");
	}
	
	}

	
}
