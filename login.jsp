<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
  <style>
    @charset "UTF-8";
    body {
   
      background: url('/foodApp/images/login.jpeg'); /* Gradient background */
      font-family: Arial, sans-serif;
      height: 100vh;
      margin: 0;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .div1 {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100%;
      width: 100%;
    }

    form {
      background: rgba(255, 255, 255, 0.1); /* Transparent background */
      border: solid #fff 1px;
      border-radius: 15px;
      width: 400px;
      padding: 20px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      backdrop-filter: blur(10px); /* Glassmorphism effect */
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      height: 340px;
    }

    input[type="email"], input[type="password"], input[type="submit"] {
      height: 45px;
      width: 100%;
      margin-bottom: 20px;
      border-radius: 8px;
      border: 1px solid #fff;
      background: rgba(255, 255, 255, 0.3); /* Slightly transparent input background */
      font-size: 18px;
      color: #fff;
      padding-left: 10px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      border: none;
      background-color: #4CAF50 ;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color:#FF5722 ; /* Change color to green on hover */
    }

    form h1 {
      color: white;
      text-align: center;
      margin-bottom: 20px;
    }

    form p {
      text-align: center;
      margin-top: auto;
      color: white;
    }

    form a {
      color:#4CAF50 ;
      text-decoration: none;
      font-size: 16px;
      display: inline-block;
      margin-top: 10px;
    }

    form a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="div1">
    <form action="login">
      <h1>Login</h1>
      <input type="email" name="email" required="required" placeholder="Email"><br>
      <input type="password" name="password" placeholder="Password"><br>
      <input type="submit" value="SignIn" class="login">
      <p>Don't have an Account? <a href="register.jsp">Register</a></p>
    </form>
  </div>
</body>
</html>