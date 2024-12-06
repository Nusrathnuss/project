package com.foodApp.Servlets;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	RestaurantDaoImpl restaurant = new RestaurantDaoImpl();
   	//	  List<Restaurant> allRestaurant = restaurant.getAllRestaurant();
   	//	  HttpSession session = request.getSession();
   	//S	  session.setAttribute("restaurantList", allRestaurant);
   		  response.sendRedirect("home.jsp");
   		
   		
		
	}

}
