package com.foodApp.DaoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Connect.Connect;
import com.foodApp.DAO.OrderTableDao;
import com.foodApp.modules.OrderTable;

public class OrderTableImpl implements OrderTableDao {
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status1;
	private List<OrderTable>orderTableList=null;
	
	private static final String  ADD_ORDERTABLE_QUERY="insert into ordertable ( restaurantId,  userId,  orderDate,  totalAmount,  status, paymentMode) "+
	                           "values(?,?,?,?,?,?)";
	private static final String  GET_ALL_ORDERTABLE_QUERY="select * from ordertable where userId=?";
	private static final String  GET_ORDERTABLE_QUERY="select * from ordertable where orderId=?";
	
	public OrderTableImpl() {
		con=Connect.getConnect();
	}
	
	

	@Override
	public int addOrderTable(OrderTable o) {
		// TODO Auto-g1enerated method stub
		try {
			pstmt=con.prepareStatement(ADD_ORDERTABLE_QUERY);
			pstmt.setInt(1,o.getRestaurantId());
			pstmt.setInt(2, o.getUserId());
			pstmt.setString(3,o.getOrderDate());
			pstmt.setFloat(4,o.getTotalAmount());
			pstmt.setString(5,o.getStatus());
			pstmt.setString(6,o.getPaymentMode());
			status1=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status1;
	}

	@Override
	public List getAllOrderTable(int userId) {
		try {
			
			pstmt=con.prepareStatement(GET_ALL_ORDERTABLE_QUERY);
			pstmt.setInt(1, userId);
			res=pstmt.executeQuery();
			orderTableList=new ArrayList<OrderTable>();
			while(res.next()) {
				
				int orderId=res.getInt("orderId");
				int restaurantId=res.getInt("restaurantId");
				//int userId=res.getInt("userId");
				String orderDate=res.getString("orderDate");
				float totalAmount=res.getFloat("totalAmount");
				String status=res.getString("status");
				String paymentMode=res.getString("paymentMode");
				OrderTable orderTable = new OrderTable(orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode);
				orderTableList.add(orderTable);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderTableList;
	}

	@Override
	public OrderTable getOrderTable(int orderId) {
		OrderTable order=null;
		
		try {
			pstmt=con.prepareStatement(GET_ORDERTABLE_QUERY);
			pstmt.setInt(1, orderId);
			res=pstmt.executeQuery();
			res.next();
			//int orderId=res.getInt("orderId");
			int restaurantId=res.getInt("restaurantId");
			int userId=res.getInt("userId");
			String orderDate=res.getString("orderDate");
			float totalAmount=res.getFloat("totalAmount");
			String status=res.getString("status");
			String paymentMode=res.getString("paymentMode");
			 order = new OrderTable(orderId, restaurantId, userId, orderDate, totalAmount, status, paymentMode);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

}