package com.foodApp.Test;

import java.util.List;

import com.foodApp.DaoImpl.MenuDaoImpl;
import com.foodApp.modules.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

          MenuDaoImpl menu = new MenuDaoImpl();
         //RestaurantDaoImpl res=new RestaurantDaoImpl();
        // System.out.println(res.getRestaurant(1));
          List<Menu> allMenu = menu.getAllMenu(2);
          for(Menu m:allMenu) {
        	  System.out.println(m);
          }
          
		
		
		
	}

}