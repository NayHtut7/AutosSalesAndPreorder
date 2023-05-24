<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="common/header.jsp"></c:import>
	<title>Sign in Page</title>
</head>
<body style="background-image: url('assets/agera.jpg');background-size: 100%">
	
	<div class="container">
    <form action="login" method="post">
    	<a class="navbar-brand"  style="font-style: oblique; font-weight: bolder; font-size:xx-large;"> <img id="logo"
				src="assets/logo.jpg" alt="logo" />  AUTO SPOT</a>
        <h4 class="mb-3 text-center">Please Sign in</h4>
        
        <input type="hidden" name="mode" value="LOGIN">
        
        <c:if test="${loginFail }">
        <div class="mb-3">
        <span class="alert alert-danger"> Username or password is incorrect</span>
        </div>
        </c:if>
        
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter Your Email" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter Your Password" class="form-control" required="required" autofocus>
        </div>
        
        <button type="submit" class="btn btn-success">Sign In</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
     <p> Don't have an account? </p>
     <a href="user">Please Sign Up</a> 
</div> <!-- ./container -->
	
	
<c:import url="common/footer.jsp"></c:import>
</body>
</html>