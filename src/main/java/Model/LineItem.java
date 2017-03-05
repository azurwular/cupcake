/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author azurwular
 */
public class LineItem
{
    private Topping topping;
    
    private Bottom bottom;

    private int quantity;

    private String username;
    
    private int invoiceId ;

    public LineItem(Topping topping, Bottom bottom, String username)
    {
        this.topping = topping;
        this.bottom = bottom;
        this.quantity = 1;
        this.username = username;
    }

    public Topping getTopping()
    {
        return topping;
    }

    public void setTopping(Topping topping)
    {
        this.topping = topping;
    }

    public Bottom getBottom()
    {
        return bottom;
    }

    public void setBottom(Bottom bottom)
    {
        this.bottom = bottom;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public void increaseQuantity()
    {
        this.quantity ++;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getInvoiceId()
    {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId)
    {
        this.invoiceId = invoiceId;
    }

    
}

