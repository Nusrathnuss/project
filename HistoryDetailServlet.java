package com.foodApp.Servlets;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DaoImpl.OrderItemDaoImpl;
import com.foodApp.modules.OrderItem;

/**
 * Servlet implementation class HistoryDetailServlet
 */
@WebServlet("/historyDetail")
public class HistoryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		ArrayList<OrderItem> orderList = (ArrayList<OrderItem>) new OrderItemDaoImpl().getAllOrderItem(orderId);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", orderList);
		response.sendRedirect("historyDetail.jsp");
	}

}
