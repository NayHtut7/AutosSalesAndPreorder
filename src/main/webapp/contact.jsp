<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="common/header.jsp"></c:import>
<title>Contact Page</title>
    <style>
      
      p{
        font-size: x-large;
      }
      .form{
        padding: 30px;
        width: 500px;
        margin: 0 auto;
        color: black;
        margin-top: 30px;
        border-radius: 5px;
        
      }

      .title{
        font-size: 25px;
        text-align: center;
      }
      .title h1{
        margin: 0px;
        color: black;
        font-weight: bold;
      }
      .description{
        text-align: center;

      }

      .form-input input, .form-input textarea{
        width: 100%;
        margin: 15px 0px;
        font-size: 18px;
        font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
        border-radius: 0px;
        border: 1px solid black;
      }
      .btn{
        padding: 8px 0px;
        width: 100%;
        margin-top: 15px;
        background-color: black;
        border: none;
        color: white;
      }
     .form{
      display: none;
     }
    </style>
     <script>
      $(function(){
       
          $('.form').toggle(6000)

    
    })
    </script>
</head>
<body style="background-image: url('assets/lambo.jpg'); background-size: 100%">
        <c:import url="common/nav.jsp"></c:import>
   
    <div class="form">

      <div class="title ">
        <h1>Contact Us</h1>
      </div>

      <div class="description">
          <p>
            We know sometimes you need to contact us,
            and we want to make sure we get you in touch
            with us for your specific query.
            
            </p>
       </div>

       <div class="form-input">
        <form >
          Name : <br>
          <input type="text" placeholder="Enter Your Name"><br>
          Email : <br>
          <input type="text" placeholder="Enter Your Email"><br>
          Message : <br>
          <textarea rows="5" placeholder="Message..."></textarea>
          <button class="btn"> Send</button>

        </form>

       </div>

     
    </div>
          <c:import url="common/footer.jsp"></c:import>
</body>
</html>