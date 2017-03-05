<%-- 
    Document   : newUser
    Created on : 02-Mar-2017, 08:26:40
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
    <body>
        <h1>Sign Up here!</h1>
        <form role="form" method="POST" action="newUser">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="username" type="text" class="form-control" name="username" placeholder="Username">
   
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="password" type="password" class="form-control" name="password" placeholder="Password">
      <input id="password" type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password">
    </div>
      <br>
      <button type="submit" class="btn btn-success">Confirm</button>
      </form>
    
    </body>
</html>
