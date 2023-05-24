<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
      	<c:import url="common/header.jsp"></c:import>
        <title>Reserved Cars List</title>
       
    </head>
    <body style="background-image: url('assets/mclaren.jpg');background-size: 100%">
       
        <!-- Responsive navbar-->
        <c:import url="common/nav.jsp"></c:import>
        <!-- Page content-->
        <div class="container mt-5" >
        
        	
                <table id="listTable" class="table table-striped" style="width:100%">
                    <thead>
                        <tr style="font-style: italic;">
                            <th>Serial No</th>
                            <th>Customer</th>
                            <th>Phone</th>
                            <th>Date</th>
                            <th>Car</th>
                            <th>Engine</th>
                            <th>Model</th>
                            <th>Trim</th>
                            <th>Color</th>
                            <th>Price</th>
                            <th>Actions</th>
                            
                           
                       <!--      	
						<c:if test="${user.role == 'admin' }">
							<th>Actions</th>
						</c:if>
						 -->
                            
                       </tr>
                    </thead>
                    <tbody>
                     <c:forEach var="customer" items="${reservedList }">
                       
                     <c:url var="editLink" value="cars">
                     	<c:param name="mode" value="LOAD"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                     <c:url var="clearLink" value="customer">
                     	<c:param name="mode" value="CLEAR"></c:param>
                     	<c:param name="id" value="${customer.id }"></c:param>
                     </c:url>
                      <c:url var="buyLink" value="cars">
                     	<c:param name="mode" value="LOAD"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                     
                        <tr>
                            <td>${customer.id }</td>
                            <td>${customer.name }</td>
                            <td>${customer.phone }</td>
                      	    <td>${customer.date}</td>
                            <td>${customer.car }</td>
                            <td>${customer.engine }</td>
                            <td>${customer.model }</td>
                            <td>${customer.trim }</td>
                            <td>${customer.color }</td>
                            <td>${customer.price }</td>
                           <!--  
                            <td>
                             	<c:choose>
                             	
                             		<c:when test="${result.qualify }">
                             		
                             			*Qualified!
                             			
                             		</c:when>
                             		<c:otherwise>
                             		
                             		</c:otherwise>
                             	</c:choose>
                            
                            </td>
                            -->  
                                   	
						    <c:if test="${user.role == 'admin' }">
						  	<td>
                            	
                            	
                            	<a href="${clearLink }"  class="btn btn-danger"  onclick="return confirm('Are you sure want to clear?')">
                            	 Clear</a>
                            	
                             </td>
						  </c:if>
						  
						  
						
                              
                        </tr>
                        </c:forEach>
                        
                    </tbody>
                    <tfoot>
                        <tr style="font-style: italic;">
                            <th>Serial No</th>
                            <th>Customer</th>
                            <th>Phone</th>
                            <th>Date</th>
                            <th>Car</th>
                            <th>Engine</th>
                            <th>Model</th>
                            <th>Trim</th>
                            <th>Color</th>
                            <th>Price</th>
                            <th>Actions</th>
                          
                         <!--          	
						<c:if test="${user.role == 'admin' }">
							<th>Actions</th>
						</c:if>
						 --> 
                        </tr>
                    </tfoot>
                </table>
           
        </div>
      <c:import url="common/footer.jsp"></c:import>
        
       
        	
       
        
        <script>
            $(document).ready(function () {
                 $('#listTable').DataTable();
            });
        </script>
    </body>
</html>
    