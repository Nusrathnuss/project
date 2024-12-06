package com.foodApp.DAO;



import java.util.List;

import com.foodApp.modules.Restaurant;

public interface RestaurantDao {
	int addRestaurant(Restaurant r);
    List getAllRestaurant();
    Restaurant getRestaurant(int restaurantId );
    int updateMenu(Restaurant r);
    int deleteMenu(int restaurantId);
    String restaurantName(int restaurantId);
	

}