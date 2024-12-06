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
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/profileupdate")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");

		String email = request.getParameter("email");
		if (email != null && !email.trim().isEmpty()) {
			user.setEmail(email);
		}

		String userName = request.getParameter("userName");
		if (userName != null && !userName.trim().isEmpty()) {
			user.setUserName(userName);
		}

		String phoneNumber = request.getParameter("phoneNumber");
		if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
			user.setPhoneNumber(phoneNumber);
		}

		String address = request.getParameter("address");
		if (address != null && !address.trim().isEmpty()) {
			user.setAddress(address);
		}

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.updateUser(user);

		session.setAttribute("loginUser", user);
		System.out.println("after" + (User) session.getAttribute("loginUser"));
		response.sendRedirect("home");
	}
}