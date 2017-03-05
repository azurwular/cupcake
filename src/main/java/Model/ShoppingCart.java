/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author azurwular
 */
public class ShoppingCart
{
    private ArrayList<LineItem> lineItems;

    public ShoppingCart()
    {
        this.lineItems = new ArrayList<>();
    }

    public ArrayList<LineItem> getLineItems()
    {
        return lineItems;
    }
    
    public void addLineItem(LineItem lineItem)
    {
        this.lineItems.add(lineItem);
    }
}
