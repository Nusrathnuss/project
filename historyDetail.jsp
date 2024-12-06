<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodApp.modules.*, java.util.List, com.foodApp.DaoImpl.*, com.foodApp.modules.*"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Order History</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <style>
    /* Basic navbar styling */
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    overflow-x: hidden;
}

/* Navbar styles */
.navbar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    background-color: #004d00; /* Dark green background */
    color: white;
}

.navbar-left {
    display: flex;
    align-items: center;
}

.navbar-left .logo {
    height: 40px;
    margin-right: 10px;
}

.navbar-left .company-name {
    font-size: 24px;
    font-weight: 600;
}

.navbar-center {
    font-size: 18px;
    font-weight: 500;
    text-align: center;
    padding-top: 5px;
}

.nav-menu {
    display: flex;
    list-style-type: none;
    margin: 0;
    padding: 0;
    align-items: center;
}

.nav-menu li {
    position: relative;
    margin-left: 20px;
}

.nav-menu li a {
    color: white;
    text-decoration: none;
    font-size: 16px;
    padding: 6px 10px;
    border-radius: 5px;
    transition: background-color 0.3s ease, color 0.3s ease;
    vertical-align: middle;
}

.nav-menu li a:hover {
    background-color: #FF5722; /* Hover background color */
    color: #fff;
}

.dropdown .dropbtn {
    background: none;
    border: none;
    color: white;
    cursor: pointer;
    font-size: 16px;
    padding: 6px 10px;
    border-radius: 5px;
    transition: background-color 0.3s ease, color 0.3s ease;
    margin-top: 5px; /* Lower the profile button slightly */
}

.dropdown .dropbtn:hover {
    background-color: #FF5722; /* Hover background color */
}

.dropdown-content {
    display: none;
    position: absolute;
    right: 0;
    background-color: #004d00;
    min-width: 180px;
    box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
    z-index: 1;
    border-radius: 5px;
    margin-top: 5px; /* Close to the button to prevent gap */
}

.dropdown-content a {
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
    transition: background-color 0.3s ease, color 0.3s ease;
}

.dropdown-content a:hover {
    background-color: #FF5722; /* Hover background color */
}

/* Ensure the dropdown stays open when hovering over the dropdown content */
.dropdown:hover .dropdown-content,
.dropdown-content:hover {
    display: block;
}

.show {
    display: block;
}

    /* Order History Styling */
    .container {
      padding: 20px;
    }

    header {
    text-align: center;
    margin-bottom: 30px;
}

header h1 {
    color: #007bff;
    font-size: 2.5em;
}
    
    .order-history {
      display: flex;
      flex-wrap: wrap;
      gap: 20px;
      justify-content: center;
    }

    .order-card {
      background: white;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      width: 300px;
      margin: 10px;
      display: flex;
      flex-direction: column;
      align-items: center;
      padding: 10px;
    }

    .order-image {
      width: 100%;
      height: 200px;
      object-fit: cover;
    }

    .order-details {
      padding: 10px;
      text-align: center;
    }

    .order-details h2 {
      font-size: 18px;
      margin: 10px 0;
      color: #FF5722;
    }

    .order-details p {
      font-size: 16px;
      margin: 5px 0;
    }

    /* Footer Styling */
    .footer {
      background-color: #004d00; /* Main theme color */
      color: white;
      padding: 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      position: relative;
      bottom: 0;
      width: 100%;
    }

    .footer-content {
      display: flex;
      justify-content: space-between;
      width: 100%;
      max-width: 1200px;
      padding: 0 20px;
    }

    .footer-left, .footer-center, .footer-right {
      flex: 1;
      margin: 0 10px;
    }

    .footer-logo {
      height: 40px;
      margin-bottom: 10px;
    }

    .footer-center h3, .footer-right h3 {
      margin-top: 0;
    }

    .footer-center p, .footer-right p {
      margin: 5px 0;
    }

    .social-icon {
      color: white;
      font-size: 24px;
      margin-right: 10px;
      transition: color 0.3s ease;
    }

    .social-icon:hover {
      color: #FFCCBC; /* Highlight color on hover */
    }

    .footer-bottom {
      text-align: center;
      margin-top: 20px;
    }

    .footer-bottom a {
      color: white;
      text-decoration: none;
      margin: 0 10px;
    }

    .footer-bottom a:hover {
      text-decoration: underline;
    }
  </style>
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


  <div class="container">
    <header>
     <h1>Ordered Items List</h1> 
    </header>
    <main>
      <div class="order-history">
        <% List<OrderItem> orderList = (List<OrderItem>) session.getAttribute("orderList");
        if (orderList != null) {
          for (OrderItem his : orderList) {
        	int menuId=his.getMenuId();
        	Menu menu=new MenuDaoImpl().getMenu(menuId);
        	  
        	  %>
            <div class="order-card">
              <img src="<%=request.getContextPath() %>/images/<%=menu.getImgPath() %>" alt="Item Image" class="order-image">
              <div class="order-details">
                <h2>ItemId: <%= his.getOrderItemId() %></h2>
                <p><strong>Quantity:</strong> <%= his.getQuantity() %></p>
                <p><strong>MenuId:</strong> <%= his.getMenuId() %></p>
                <p><strong>Amount:</strong> $<%= his.getSubTotal() %></p>
              </div>
            </div>
        <% }} %>
      </div>
    </main>
  </div>

  <footer class="footer">
    <div class="footer-content">
      <div class="footer-left">
        <img src="logo.png" alt="Company Logo" class="footer-logo">
        <p>&copy; 2024 Company Name. All rights reserved.</p>
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