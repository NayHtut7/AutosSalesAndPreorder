<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
      	<c:import url="common/header.jsp"></c:import>
        <title>Preorder Cars List</title>
       
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
                            <th>Deposit</th>
                           
                       <!--      	
						<c:if test="${user.role == 'admin' }">
							<th>Actions</th>
						</c:if>
						 -->
                            
                       </tr>
                    </thead>
                    <tbody>
                     <c:forEach var="preorder" items="${preorderList }">
                       
                     <c:url var="editLink" value="cars">
                     	<c:param name="mode" value="LOAD"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                     <c:url var="deleteLink" value="cars">
                     	<c:param name="mode" value="DELETE"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                      <c:url var="buyLink" value="cars">
                     	<c:param name="mode" value="LOAD"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                     
                        <tr>
                            <td>${preorder.id }</td>
                            <td>${preorder.name }</td>
                            <td>${preorder.phone }</td>
                      	    <td>${preorder.date}</td>
                            <td>${preorder.car }</td>
                            <td>${preorder.engine }</td>
                            <td>${preorder.model }</td>
                            <td>${preorder.trim }</td>
                            <td>${preorder.color }</td>
                            <td>${preorder.deposit }</td>
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
                            <th>Deposit</th>
                          
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
    