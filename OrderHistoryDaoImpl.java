package com.foodApp.DaoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.Connect.Connect;
import com.foodApp.DAO.OrderHistoryDao;
import com.foodApp.modules.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet res;
    private int status1;
    private List<OrderHistory> orderHistoryList;

 // In OrderHistoryDaoImpl

    private static final String ADD_ORDERHISTORY_QUERY = "INSERT INTO orderhistory (orderId, userId, totalAmount, status, orderDate) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_ALL_ORDERHISTORY_QUERY = "SELECT * FROM orderhistory WHERE userId = ?";
    private static final String GET_ORDERHISTORY_QUERY = "SELECT * FROM orderhistory WHERE orderHistoryId = ?";

    public OrderHistoryDaoImpl() {
		 con = Connect.getConnect();
	}
    
    
    
    @Override
    public int addOrderHistory(OrderHistory o) {
        try {
            pstmt = con.prepareStatement(ADD_ORDERHISTORY_QUERY);
            pstmt.setInt(1, o.getOrderId());
            pstmt.setInt(2, o.getUserId());
            pstmt.setFloat(3, o.getTotalAmount());
            pstmt.setString(4, o.getStatus());
            pstmt.setString(5, o.getOrderDate()); // Added orderDate
            status1 = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status1;
    }

    @Override
    public List<OrderHistory> getAllOrderHistory(int userId) {
        try {
            pstmt = con.prepareStatement(GET_ALL_ORDERHISTORY_QUERY);
            pstmt.setInt(1, userId);
            res = pstmt.executeQuery();
            orderHistoryList = new ArrayList<>();
            while (res.next()) {
                int orderHistoryId = res.getInt("orderHistoryId");
                int orderId = res.getInt("orderId");
                float totalAmount = res.getFloat("totalAmount");
                String status = res.getString("status");
                String orderDate = res.getString("orderDate"); // Fetch orderDate
                OrderHistory orderHistory = new OrderHistory(orderHistoryId, orderId, userId, totalAmount, status, orderDate);
                orderHistoryList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        OrderHistory orderHistory = null;
        try {
            pstmt = con.prepareStatement(GET_ORDERHISTORY_QUERY);
            pstmt.setInt(1, orderHistoryId);
            res = pstmt.executeQuery();
            if (res.next()) {
                int orderId = res.getInt("orderId");
                int userId = res.getInt("userId");
                float totalAmount = res.getFloat("totalAmount");
                String status = res.getString("status");
                String orderDate = res.getString("orderDate"); // Fetch orderDate
                orderHistory = new OrderHistory(orderHistoryId, orderId, userId, totalAmount, status, orderDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }
}