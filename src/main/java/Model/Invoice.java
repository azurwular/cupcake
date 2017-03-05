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
public class Invoice
{
    private int id;

    private ArrayList<LineItem> lineItems;

    private String username;

    public Invoice(int id, ArrayList<LineItem> lineItems, String username)
    {
        this.id = id;
        this.lineItems = lineItems;
        this.username = username;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public ArrayList<LineItem> getLineItems()
    {
        return lineItems;
    }

    public void setLineItems(ArrayList<LineItem> lineItems)
    {
        this.lineItems = lineItems;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
    
    
}
