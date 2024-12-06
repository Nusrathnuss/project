package com.foodApp.Servlets;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DaoImpl.UserDaoImpl;
import com.foodApp.modules.User;

/**
 * Servlet implementation class UpdateAddressServlet
 */
@WebServlet("/update")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String address = request.getParameter("address");
		  HttpSession session = request.getSession();
		  User user=(User)session.getAttribute("loginUser");
		  user.setAddress(address);
		  UserDaoImpl userDaoImpl = new UserDaoImpl();
		  userDaoImpl.updateUser(user);
		  session.setAttribute("loginUser", user);
		  response.sendRedirect("viewCart.jsp");
		  
    	
    	
    	
    	}

	

}
