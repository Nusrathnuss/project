package com.foodApp.Servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DaoImpl.OrderHistoryDaoImpl;
import com.foodApp.modules.OrderHistory;


@WebServlet("/ordersHistory")
public class OrdersHistory extends HttpServlet {
    // Changed to doGet to handle GET requests from anchor tags
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId")); // Retrieve userId parameter from URL
        OrderHistoryDaoImpl dao = new OrderHistoryDaoImpl();
        List<OrderHistory> allOrderHistory = dao.getAllOrderHistory(userId); // Get order history for the user
        HttpSession session = request.getSession();
        session.setAttribute("orderHistoryList", allOrderHistory); // Store order history in session
        response.sendRedirect("orderHistory.jsp"); // Redirect to orderHistory.jsp
    }
}