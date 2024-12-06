package com.foodApp.DAO;


import java.util.List;

import com.foodApp.modules.Menu;

public interface MenuDao {
    int addMenu(Menu m);
    List getAllMenu( int RestaurantId);
    Menu getMenu(int menuId);
    int updateMenu(Menu m);
    int deleteMenu(int menuId);
	
	
}