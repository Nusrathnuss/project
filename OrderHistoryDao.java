package com.foodApp.DAO;



import java.util.List;

import com.foodApp.modules.OrderHistory;

public interface OrderHistoryDao {
	int addOrderHistory(OrderHistory o);
    List getAllOrderHistory(int userId);
    OrderHistory getOrderHistory(int orderHistoryId );

}