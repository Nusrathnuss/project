<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.foodApp.modules.*,java.util.List,com.foodApp.DaoImpl.*"%>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Food Delivery Service</title>
    <link rel="stylesheet" href="home.css">
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
            <li><a href="#home"><i class="fas fa-home"></i> Home</a></li>
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
    <h2>Our Partner Restaurants</h2>
    <div class="restaurant-grid">
        <% RestaurantDaoImpl restaurant1 = new RestaurantDaoImpl();
        List<Restaurant> restaurantList = restaurant1.getAllRestaurant();
        if (restaurantList != null) {
            for (Restaurant restaurant : restaurantList) { %>
                <a href="menuServlet?restaurantId=<%= restaurant.getRestaurantId() %>" class="restaurant-anchor">
                    <div class="restaurant-card">
                        <img src="<%=request.getContextPath() %>/images/<%=restaurant.getImgPath() %>" alt="<%= restaurant.getRestaurantName() %>">
                        <div class="restaurant-details">
                            <h3><%= restaurant.getRestaurantName() %></h3>
                            <p><strong>Cuisine Type:</strong> <%= restaurant.getCuisineType() %></p>
                            <p><strong>Delivery Time:</strong> <%= restaurant.getDeliveryTime() %></p>
                        </div>
                    </div>
                </a>
            <% } %>
        <% } %>
    </div>
</section>
 <footer class="footer">
        <div class="footer-content">
            <div class="footer-left">
                <img src="/foodApp/images/logo.png" alt="Company Logo" class="footer-logo">
                <p>Delivering delicious food to your doorsteps since 2023.</p>
            </div>
            <div class="footer-center">
                <h3>Contact Us</h3>
                <p><i class="fas fa-map-marker-alt"></i> 1234 Food Street, City, State, 12345</p>
                <p><i class="fas fa-phone"></i> (123) 456-7890</p>
                <p><i class="fas fa-envelope"></i> info@fooddelivery.com</p>
            </div>
            <div class="footer-right">
                <h3>Follow Us</h3>
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-twitter"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2023 Food Delivery Service. All rights reserved.</p>
            <p>Design by <a href="#">YourName</a></p>
        </div>
    </footer>

    <script src="home.js"></script>
</body>
</html>