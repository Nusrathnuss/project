package com.foodApp.Servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DaoImpl.MenuDaoImpl;
import com.foodApp.modules.Menu;

/**
 * Servlet implementation class MenuSerlet
 */
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int restauarntId =Integer.parseInt( request.getParameter("restaurantId"));
		  MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		  List<Menu> allMenu = menuDaoImpl.getAllMenu(restauarntId);
		  HttpSession session = request.getSession();
		  session.setAttribute("menuList", allMenu);
		  session.setAttribute("restaurantId",restauarntId);
		  response.sendRedirect("menu.jsp");
		  
		  
    	
    	
    	
    	}

	
}