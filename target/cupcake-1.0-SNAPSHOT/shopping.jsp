<%-- 
    Document   : shopping
    Created on : Feb 27, 2017, 2:20:17 PM
    Author     : kasper
--%>

<%@page import="Model.LineItem"%>
<%@page import="Model.ShoppingCart"%>
<%@page import="Model.User"%>
<%@page import="Model.ModelFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  User user = (User) session.getAttribute("currentSessionUser");
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        %>

        <%
            String[] toppings = ModelFacade.getToppings();
            String[] bottoms = ModelFacade.getBottoms();
        %>

        <h1>Cake Shop</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>User</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getBalance() %></td> 
                </tr>
            </tbody>
        </table>

        <form method="POST" action="ShoppingCart">
            <table border="1">
                <thead>
                    <tr>
                        <th>Bottom</th>
                        <th>Topping</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>  
                        <td><select name="Bottom">
                                <% for (String b : bottoms) {%>
                                <option><%=b%></option>
                                <%}%>
                            </select></td>
                        <td><select name="Topping">
                                <% for (String b : toppings) {%>
                                <option><%=b%></option>
                                <%}%>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="submit" />
        </form>
        <% if (shoppingCart.getLineItems().size() > 0) { %>
        <table>
            <thead><th>bottom</th><th>Topping</th><th>Price</th></thead>
            <tbody>
                <% for (LineItem lineItem : shoppingCart.getLineItems()) { %>
                <td><%=lineItem.getBottom().getName() %></td>
                <td><%=lineItem.getTopping().getName() %></td>
                <td><%= Math.round(lineItem.getBottom().getPrice() + lineItem.getTopping().getPrice()) %></td>
            <%}%>
            </tbody>
        </table>
        <%}%>
    </body>
</html>
