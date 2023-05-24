<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="common/header.jsp"></c:import>
	<title>User Register Page</title>
		<style type="text/css">
		input{
			width: 100%;
			padding:  12px;
			border: 1 px solid #ccc;
			border-radius: 4px;
			box-sizing: border-box;
			margin-top: 6px;
			margin-bottom: 16px;
		}
		#message {
 		 display:none;
 		 background-color:white;
 		 color: #000;
 		 position: relative;
 		 padding: 20px;
 		 margin-top: 10px;
		}
		#message p {
 		 padding: 10px 35px;
	  font-size: 18px;
		}
			.valid {
  			color: green;
	}

		.valid:before {
  		position: relative;
 		 left: -35px;
  		content: "True";
	}
	.invalid {
  color: red;
}

.invalid:before {
  position: relative;
  left: -35px;
  content: "False";
}
		
	</style>
	
	
</head>
<body style="background-image: url('assets/agera.jpg');background-size: 100%">
	<c:import url="common/nav.jsp"></c:import>
	<div class="container">
    <form action="admin" method="post">
    	<a class="navbar-brand"  style="font-style: oblique; font-weight: bolder; font-size:xx-large;"></a>
        <h2 class="mb-3 text-center"  >Set Admin</h2>
        
        <input type="hidden" name="mode" value="CREATE">
        
        <div class="mb-3">
            <label for="username" class="form-label">*Username</label>
            <input type="text" id="username" name="username" placeholder="Enter Your Name" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="email" class="form-label">*Email</label>
            <input type="email" id="email" name="email" placeholder="Enter Your Email" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="password" class="form-label">*Password</label>
            <input type="text" id="password" name="password" placeholder="Enter Your Password" class="form-control" required="required" autofocus>
        </div>
        
         
        <div class="mb-3 form-check">
      		<input type="checkbox" class="form-check-input" id="role" name="role" value="true">
      		<label class="form-check-label" for="role">Admin</label>
    	</div>
        
        <div class="mb-3">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block" style="color: red;">*Required fields</span>
            </div>
        </div>
        
        <button type="submit" class="btn btn-success">Add</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
     <div id = "message">
    		<h3>Password must contain the following;</h3>
    		<p id = "letter" class = "invalid">A <b>Lowercase Letter</b></p>
    		<p id ="capital" class="invalid"  >A <b>Uppercase Letter</b></p>
    		<p id = "number" class ="invalid">A <b>number</b></p>
    		<p id = "length" class="invalid"  >Minimum <b> 8 characters</b></p>
    	</div>
    
</div> <!-- ./container -->
	<script>
var myInput = document.getElementById("password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
}

  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }

  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>
	
	
<c:import url="common/footer.jsp"></c:import>
</body>
</html>