<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>   
    <form name = "loginForm" method ="post" action="login">  
        <div class="container">   
            <label>Name : </label>   
            <input type="text" placeholder="Enter Username" name="username" required>  
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" name="password" required>  
            <button type="submit">Login</button>   
               
        </div>   
    </form>     
	<a href = 'index.jsp'>Go back to Main</a><br>
</body>
</html>