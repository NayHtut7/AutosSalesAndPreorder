<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <c:import url="common/header.jsp"></c:import>
<title>Preorder Form</title>
	<style type="text/css">
		
		.form-label{
			font-style: italic;
			font-weight: bolder;
		}
	</style>
<!-- CDN-->
</head>
<body>
<!-- Responsive navbar-->
	<c:import url="common/nav.jsp"></c:import>
	
	<div class="container">
    <form action="preorder" method="post">
        <h2 class="text-center">Preorder Form</h2>
        
        <input type="hidden" name="mode" value="PREORDER">
        
         
        <div class="mb-3">
            <label for="name" class="form-label">*Customer Name</label>
            <input type="text" id="name" name="name" placeholder=" Customer Name" class="form-control" required="required" autofocus>
        </div>
         
        <div class="mb-3">
            <label for="phone" class="form-label">*Phone</label>
            <input type="text" id="phone" name="phone" placeholder=" Phone" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="date" class="form-label">*Date</label>
            <input type="date" id="date" name="date" placeholder="Choose Date" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="car" class="form-label">*Car</label>
            <input type="text" id="car" name="car"  placeholder=" Car" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="engine" class="form-label">*Engine</label>
            <input type="text" id="engine" name="engine" placeholder="Engine" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="model" class="form-label">*Model</label>
            <input type="number" id="model" name="model" placeholder="Model Year" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="trim" class="form-label">*Trim</label>
            <input type="text" id="trim" name="trim"  placeholder="Trim" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="color" class="form-label">*Color</label>
            <input type="text" id="color" name="color"  placeholder="Color" class="form-control" required="required" autofocus>
        </div>
        
        
         <div class="mb-3">
            <label for="deposit" class="form-label">*Deposit</label>
            <input type="text" id="deposit" name="deposit"  placeholder="Deposit" class="form-control" required="required" autofocus>
        </div>
    	
    	<div class="mb-3">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block" style="font-style: italic; font-weight: bolder; color: red;">*Required fields</span>
            </div>
        </div>
        
        <button type="submit" class="btn btn-success">Preorder</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
</div> <!-- ./container -->
	
	      <c:import url="common/footer.jsp"></c:import>
	
</body>
</html>