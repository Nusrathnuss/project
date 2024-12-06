package com.foodApp.DaoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Connect.Connect;
import com.foodApp.DAO.OrderItemDao;
import com.foodApp.modules.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status1;
	private List<OrderItem>orderItemList=null;
	
	private static final String  ADD_ORDERITEM_QUERY="insert into orderitem (orderId,menuId,quantity, subTotal) "+
	                           "values(?,?,?,?)";
	private static final String  GET_ALL_ORDERITEM_QUERY="select * from orderitem where orderId=?";
	private static final String  GET_ORDERITEM_QUERY="select * from orderitem where orderItemId=?";
	private static final String  UPDATE_QUERY="update orderitem set orderId=?, menuId=?,quantity=?,subtotal=? where OrderItemId= ?";
	private static final String  DELETE_QUERY="delete from orderitem where OrderItemId=?";
	
	
	public OrderItemDaoImpl() {
		con=Connect.getConnect();
	}
	@Override
	public int addOrderItem(OrderItem o) {
		
		try {
			pstmt=con.prepareStatement(ADD_ORDERITEM_QUERY);
			pstmt.setInt(1,o.getOrderId());
			pstmt.setInt(2, o.getMenuId());
			pstmt.setInt(3,o.getQuantity());
			pstmt.setFloat(4,o.getSubTotal());
			status1=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status1;
	}
		


	@Override
	public List getAllOrderItem(int orderId) {
		try {
			pstmt=con.prepareStatement(GET_ALL_ORDERITEM_QUERY);
			pstmt.setInt(1, orderId);
			res=pstmt.executeQuery();
			orderItemList=new ArrayList<OrderItem>();
			while(res.next()) {
				int orderItemId=res.getInt("orderItemId");
				//int orderId=res.getInt("orderId");
				int menuId=res.getInt("menuId");
				int quantity=res.getInt("quantity");
				float subTotal=res.getFloat("subTotal");
				
				OrderItem order = new OrderItem(orderItemId, orderId, menuId, quantity, subTotal);
				orderItemList.add(order);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderItemList;
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		OrderItem order=null;
		try {
			pstmt=con.prepareStatement(GET_ORDERITEM_QUERY);
			pstmt.setInt(1,orderItemId);
			res=pstmt.executeQuery();
			res.next();
			
			int orderId=res.getInt("orderId");
			int menuId=res.getInt("menuId");
			int quantity=res.getInt("quantity");
			float subTotal=res.getFloat("subTotal");
			
		    order = new OrderItem(orderItemId, orderId, menuId, quantity, subTotal);

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	@Override
	public int updateOrderItem(OrderItem o) {
		try {
			pstmt=con.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1,o.getOrderId());
			pstmt.setInt(2, o.getMenuId());
			pstmt.setInt(3,o.getQuantity());
			pstmt.setFloat(4,o.getSubTotal());
			pstmt.setInt(5, o.getOrderItemId());
			status1=pstmt.executeUpdate();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status1;
	}
	

	@Override
	public int deleteOrderItem(int orderItemId) {
		
		try {
			pstmt=con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1, orderItemId);
			status1=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status1;
	}

	
}