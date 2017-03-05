/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataAccessLayer.DataMapper;
import Model.Bottom;
import Model.LineItem;
import Model.ShoppingCart;
import Model.Topping;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author azurwular
 */
@WebServlet( name = "ShoppingCart", urlPatterns = { "/ShoppingCart" } )
public class ShoppingCartServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType( "text/html;charset=UTF-8" );
        
        // Get requested bottom and topping
        String requestedBottomString = request.getParameter("Bottom");
        String requestedToppingString = request.getParameter("Topping");
        
        // Map and fetch from db
        DataMapper dataMapper = new DataMapper();
        
        Topping requestedTopping = dataMapper.getTopping(requestedToppingString);
        Bottom requestedBottom = dataMapper.getBottom(requestedBottomString);
        
        // Fetch shopping cart from session
        HttpSession ses = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart)ses.getAttribute("shoppingCart");
        User currentUser = (User)ses.getAttribute("currentSessionUser");
        
        // Check if the line item already exists, if it does increase quantity
        ArrayList<LineItem> lineItems = shoppingCart.getLineItems();
        
        for (LineItem lineItem : lineItems)
        {
            if (lineItem.getBottom().getName() == requestedBottom.getName() &&
                lineItem.getTopping().getName() == requestedTopping.getName())
            {
                lineItem.increaseQuantity();
                
            }
        }
        
        // For a new item, add it to the shopping cart
        LineItem newLineItem = new LineItem(requestedTopping, requestedBottom, currentUser.getUsername());
        shoppingCart.addLineItem(newLineItem);
        
        // Save to session and return to shopping
        ses.setAttribute("shoppingCart", shoppingCart);
        forward("/shopping.jsp",request, response);
    }

    private void forward(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher( url )
                .forward( request, response );
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
