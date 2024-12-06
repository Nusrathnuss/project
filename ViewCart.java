package com.foodApp.Servlets;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodApp.DaoImpl.Cart;
import com.foodApp.DaoImpl.MenuDaoImpl;
import com.foodApp.modules.CartItem;
import com.foodApp.modules.Menu;


@WebServlet("/viewCart")
public class ViewCart extends HttpServlet {
    // Changed to doGet to handle GET requests from anchor tags
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /* int userId = Integer.parseInt(request.getParameter("userId")); // Retrieve userId parameter from URL
        OrderTableImpl orderTableImpl = new OrderTableImpl();
        List<OrderTable> allOrderTable = orderTableImpl.getAllOrderTable(userId); // Get orders for the user
       HttpSession session = request.getSession();
        session.setAttribute("orderList", allOrderTable); // Store orders in session
        response.sendRedirect("viewCart.jsp"); // Redirect to viewCart.jsp*/
    	 HttpSession session = request.getSession();
    	
    	String action=request.getParameter("action");
    	Cart cart=(Cart)session.getAttribute("cart");
    	if(cart==null) {
    		cart=new Cart();
    		 session.setAttribute("cart",cart );
    	}
    	if(action.equals("add")) {
    		addCart(request,cart);
    		
    	}else if(action.equals("update")) {
    		updateCart(request,cart);
    	
    	}else if(action.equals("delete")) {
    		deleteCart(request,cart);
    		
    	} 
    	session.setAttribute("cart",cart );
    	System.out.println("going from servlet");
    	 response.sendRedirect("viewCart.jsp");	
    	 	
    }
    private void deleteCart(HttpServletRequest request, Cart cart) {
    	int itemId=Integer.parseInt(request.getParameter("itemId"));
    	cart.removeItem(itemId);
	}
	private void updateCart(HttpServletRequest request, Cart cart) {
		//System.out.println(request.getParameter("itemId"));
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
	    cart.updateItem(itemId, quantity);
		System.out.println(quantity);
		System.out.println(cart.getItems().get(itemId));
		
		
	}
	public void addCart(HttpServletRequest request,Cart cart) {
    	int menuId = Integer.parseInt(request.getParameter("menuId"));
    	int quantity=Integer.parseInt(request.getParameter("quantity"));
    	MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
    	Menu menu = menuDaoImpl.getMenu(menuId);
    	if(menu!=null) {
    		int restaurantId=menu.getRestaurantId();
        	String menuName=menu.getMenuName();
        	float price=menu.getPrice();
        	//float subTotal=price*quantity;
        	 CartItem cartItem = new  CartItem(menuId, restaurantId, menuName,quantity, price);
        	 System.out.println(cartItem);
        	 cart.addItem(cartItem);
        	
    	}
    	
    }
}