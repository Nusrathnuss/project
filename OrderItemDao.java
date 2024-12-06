package com.foodApp.DAO;



import java.util.List;

import com.foodApp.modules.OrderItem;

public interface OrderItemDao {

	
	int addOrderItem(OrderItem o);
    List getAllOrderItem(int orderId);
    OrderItem getOrderItem(int orderItemId );
    int updateOrderItem(OrderItem o);
    int deleteOrderItem(int orderItemId);
	
}