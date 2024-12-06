package com.test.FoodApp;



import java.util.List;

import com.foodApp.DaoImpl.OrderHistoryDaoImpl;
import com.foodApp.modules.OrderHistory;

public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");
   /* OrderTableImpl orderTableImpl = new  OrderTableImpl();
    System.out.println(orderTableImpl.getOrderTable(1));
	   List<OrderTable> allOrderTable = orderTableImpl.getAllOrderTable(2);
	   for(OrderTable or:allOrderTable) {
		 System.out.println(or);
	   }*/
	   OrderHistoryDaoImpl dao = new OrderHistoryDaoImpl();
	   List<OrderHistory> orderHistories = dao.getAllOrderHistory(1);
       for (OrderHistory orderHistory : orderHistories) {
           System.out.println(orderHistory);
       }
    
  }
}