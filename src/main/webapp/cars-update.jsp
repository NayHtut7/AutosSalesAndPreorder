<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <c:import url="common/header.jsp"></c:import>
<title>Update Instock CarsList</title>
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
    <form action="cars" method="post">
        <h2 class="text-center">Update Instock Cars List</h2>
        
        <input type="hidden" name="mode" value="UPDATE">
        <input type="hidden" name="id" value="${cars.id }">
        <h3> <c:out value="Serial Number : ${cars.id}"></c:out> </h3>
        <div class="mb-3">
            <label for="id" class="form-label">*Serial Number</label>
            <input type="number" id="id" name="id" value="${cars.id }" placeholder=" Serial Number" class="form-control" required="required" autofocus>
        </div>
         <div class="mb-3">
            <label for="date" class="form-label">*Date</label>
            <input type="date" id="date" name="date" value="${cars.date }" placeholder="Choose Date" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="car" class="form-label">*Car</label>
            <input type="text" id="car" name="car" value="${cars.car }" placeholder=" Car" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="engine" class="form-label">*Engine</label>
            <input type="text" id="engine" name="engine" value="${cars.engine }" placeholder="Engine" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="model" class="form-label">*Model</label>
            <input type="number" id="model" name="model" value="${cars.model }" placeholder="Model Year" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="trim" class="form-label">*Trim</label>
            <input type="text" id="trim" name="trim" value="${cars.trim }" placeholder="Trim" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="color" class="form-label">*Color</label>
            <input type="text" id="color" name="color" value="${cars.color }" placeholder="Color" class="form-control" required="required" autofocus>
        </div>
        
        
         <div class="mb-3">
            <label for="price" class="form-label">*Price</label>
            <input type="text" id="price" name="price" value="${cars.price }" placeholder="Price" class="form-control" required="required" autofocus>
        </div>
         <div class="mb-3 form-check">
        	<c:choose>
        		<c:when test="${cars.remark }">
        		<input type="checkbox" class="form-check-input" id="remark" name="remark" value="true" checked="checked">
        		</c:when>
        		<c:otherwise>
        		<input type="checkbox" class="form-check-input" id="remark" name="remark" value="true">
        		</c:otherwise>
        	</c:choose>
      		<label class="form-check-label" for="qualify">*Remark</label>
    	</div>
    	
    	<div class="mb-3">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block" style="font-style: italic; font-weight: bolder; color: red;">*Required fields</span>
            </div>
        </div>
        
        <button type="submit" class="btn btn-success">Update</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
</div> <!-- ./container -->
	
	      <c:import url="common/footer.jsp"></c:import>
	
</body>
</html>