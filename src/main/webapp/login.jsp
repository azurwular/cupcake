<%-- 
    Document   : CupcakeLogin
    Created on : 28-Feb-2017, 20:48:31
    Author     : Julian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
          
          <link rel="stylesheet" href="css/style.css">
    </head>
  
    <div class="container-fluid">
  <h3>Login to your Cupcake account!</h3>
  
 
  
  <form role="form" method="POST" action="loginValidation">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="email" type="text" class="form-control" name="username" placeholder="Username">
    </div>
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" class="form-control" name="password" placeholder="Password">
    </div>
      <br>
      <button type="submit" class="btn btn-success">Login</button>
      </form>
    <form action="newUser.jsp" method="POST">
        <br>
        <button type="submit" class="btn btn-success">Signup</button>
    </form>
    <br>
    </div>
    

  
</html>


</html>
