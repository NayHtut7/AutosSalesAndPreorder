<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
      	<c:import url="common/header.jsp"></c:import>
        <title>Instock Cars List</title>
       
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
                            <th>Date</th>
                            <th>Car</th>
                            <th>Engine</th>
                            <th>Model</th>
                            <th>Trim</th>
                            <th>Color</th>
                            <th>Price</th>
                            <th>Remark</th>
                            <th>Actions</th>
                       <!--      	
						<c:if test="${user.role == 'admin' }">
							<th>Actions</th>
						</c:if>
						 -->
                            
                       </tr>
                    </thead>
                    <tbody>
                     <c:forEach var="cars" items="${carsList }">
                       
                     <c:url var="editLink" value="cars">
                     	<c:param name="mode" value="LOAD"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                     <c:url var="deleteLink" value="cars">
                     	<c:param name="mode" value="DELETE"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                      <c:url var="buyLink" value="customer">
                     	<c:param name="mode" value="LOAD"></c:param>
                     	<c:param name="id" value="${cars.id }"></c:param>
                     </c:url>
                     
                        <tr>
                            <td>${cars.id }</td>
                         
                            <td>${cars.date }</td>
                            <td>${cars.car }</td>
                            <td>${cars.engine }</td>
                            <td>${cars.model }</td>
                            <td>${cars.trim }</td>
                            <td>${cars.color }</td>
                            <td>${cars.price }</td>
                          
                             
                            <td>
                             		<c:choose>
                             	
                             		<c:when test="${cars.remark }">
                             		
                             			*Reserved!
                             			
                             		</c:when>
                             		<c:otherwise>
                             		
                             		</c:otherwise>
                             	</c:choose>
                             	
                            
                            </td>
                                      	
						  <c:if test="${user.role == 'admin' }">
						  	<td>
                            	
                            	<a href="${editLink }" class="btn btn-info"  >Edit </a>
                            	<a href="${deleteLink }"  class="btn btn-danger"  onclick="return confirm('Are you sure want to delete?')">
                            	 Delete</a>
                            	
                             </td>
						  </c:if>
						  
						  <c:if test="${user.role == 'user' }">
                            
                             <td>
                            	<a href="${buyLink }"  class="btn btn-success"  onclick="return confirm('Are you sure want to reserved?')">
                            	 Reserve</a>
                            	
                            </td>		
                             
                          </c:if>
                              
                        </tr>
                        </c:forEach>
                        
                    </tbody>
                    <tfoot>
                        <tr style="font-style: italic;">
                            <th>Serial No</th>
                            <th>Date</th>
                            <th>Car</th>
                            <th>Engine</th>
                            <th>Model</th>
                            <th>Trim</th>
                            <th>Color</th>
                            <th>Price</th>
                            <th>Remark</th>
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
    