<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.foodApp.modules.*,java.util.List,com.foodApp.DaoImpl.*"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuList</title>
<link rel="stylesheet" href="menu.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
<nav class="navbar">
        <div class="navbar-left">
            <img src="/foodApp/images/logo.png" alt="Company Logo" class="logo">
            <span class="company-name">Kane Foods</span>
        </div>
        <div class="navbar-center">
            <% User user = (User) session.getAttribute("loginUser"); %>
            <% if (user != null) { %>
                <span class="user-welcome">Welcome, <%= user.getUserName() %></span>
            <% } %>
        </div>
        <ul class="nav-menu">
            <li><a href="home.jsp"><i class="fas fa-home"></i> Home</a></li>
            <% if (user != null) { %>
                <li><a href="viewCart.jsp"><i class="fas fa-cart-shopping"></i> View Cart</a></li>
                <li><a href="ordersHistory?userId=<%= user.getUserId() %>"><i class="fas fa-history"></i> Order History</a></li>
                <li class="dropdown">
                    <button class="dropbtn">
                        <i class="fas fa-user"></i> Profile <i class="fas fa-caret-down"></i>
                    </button>
                    <div id="dropdown-content" class="dropdown-content">
                        <a href="viewProfile.jsp"><i class="fas fa-user-circle"></i> View Profile</a>
                        <a href="updateProfile.jsp"><i class="fas fa-user-edit"></i> Update Profile</a>
                        <a href="logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                    </div>
                </li>
            <% } else { %>
                <li><a href="login.jsp"><i class="fas fa-sign-in-alt"></i> Login</a></li>
                <li><a href="register.jsp"><i class="fas fa-user-plus"></i> Register</a></li>
            <% } %>
        </ul>
    </nav>

 <header class="hero-section" id="home">
        <h1>Welcome to Our Food Delivery Service</h1>
        <p>Delicious meals delivered right to your door.</p>
    </header>
  <section class="restaurants">
 
        <h2>Menu Items List</h2>
      <div class="restaurant-grid">
      <% 	
     List<Menu>menuList=(List<Menu>)session.getAttribute("menuList");
      if(menuList!=null){
      for(Menu menu:menuList){ %>
           <div class="restaurant-card">
                <img src="<%=request.getContextPath() %>/images/<%=menu.getImgPath() %>" alt="<%=menu.getImgPath()%>">
                <div class="restaurant-details">
                    <h3><%=menu.getMenuName()%></h3>
                    <p><strong>Description :</strong> <%=menu.getDescription()%></p>
                    <p><strong>Price:</strong><%= menu.getPrice()%></p>
                    <form action="viewCart" method="get">
                    <input type="hidden" name="menuId"  value="<%= menu.getMenuId()%>">
                    <input type="hidden" name="quantity" value="1">
                    <input type="hidden" name="action" value="add">
                    <input type="submit" value="Add to Cart" class="add-to-cart-btn"> 
                    </form>
                   
                </div>
            </div>
            
        <%}} %>
</div>
</section>

<footer class="footer">
    <div class="footer-content">
        <div class="footer-left">
            <img src="/foodApp/images/logo.png" alt="Company Logo" class="footer-logo">
            <p>&copy;M V Chalapathy. All rights reserved.</p>
        </div>
        <div class="footer-center">
            <h3>Contact Us</h3>
            <p><i class="fas fa-map-marker-alt"></i> 123 Food Street, Tasty Town, FL 12345</p>
            <p><i class="fas fa-phone"></i> +1 (234) 567-8901</p>
            <p><i class="fas fa-envelope"></i> <a href="mailto:support@company.com">support@company.com</a></p>
        </div>
        <div class="footer-right">
            <h3>Follow Us</h3>
            <a href="#" class="social-icon"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="social-icon"><i class="fab fa-twitter"></i></a>
            <a href="#" class="social-icon"><i class="fab fa-instagram"></i></a>
            <a href="#" class="social-icon"><i class="fab fa-linkedin-in"></i></a>
        </div>
    </div>
    <div class="footer-bottom">
        <p><a href="#">Terms of Service</a> | <a href="#">Privacy Policy</a></p>
    </div>
</footer>
 <script src="home.js"></script>

</body>
</html>