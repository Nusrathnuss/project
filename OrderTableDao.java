package com.foodApp.DAO;



import java.util.List;

import com.foodApp.modules.OrderTable;

public interface OrderTableDao {
	int addOrderTable(OrderTable o);
    List getAllOrderTable(int userId);
    OrderTable getOrderTable(int orderId );
   // int updateMenu(OrderTable o);
  //  int deleteMenu(int orderId);

}
