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
public class Cupcake
{
    private Bottom bottom;
    private Topping topping;

    public Cupcake(Bottom bottom, Topping topping)
    {
        this.bottom = bottom;
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

    public Topping getTopping()
    {
        return topping;
    }

    public void setTopping(Topping topping)
    {
        this.topping = topping;
    }
    
    
}
