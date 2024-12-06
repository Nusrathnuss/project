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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    UserDaoImpl dao=new UserDaoImpl();
	    User user=dao.getUser(email);
	    System.out.println(user);
	    if(user!=null&&password.equals(user.getPassword())) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginUser",user);
	    	response.sendRedirect("home");
	    	
	    	
	    }else {
	    	
	    	response.sendRedirect("reLogin.jsp");
	    }
	   	
   		
}

}