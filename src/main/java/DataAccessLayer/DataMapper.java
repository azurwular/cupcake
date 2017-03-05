/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import Model.Bottom;
import Model.Invoice;
import Model.LineItem;
import Model.Topping;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class DataMapper {

    private final Connection con;

    public DataMapper() {//instantiates a new connection whenever the DataMapper class is instatiated
        con = new DataAccessObject().getConnection();
    }

    public User checkUser(String username, String password) throws SQLException, NullPointerException {
        PreparedStatement insertStatement;
        ResultSet rs;
        User user = null;
        String insertSQL = "SELECT * from user where username = ? ";
        insertStatement = con.prepareStatement(insertSQL);
        insertStatement.setString(1, username);

        rs = insertStatement.executeQuery();//result set stores the results of the query

        if (rs.next()) {
            System.out.println("this method is working after rs.next");
            user = new User(rs.getString("username"), rs.getString("password"), rs.getFloat("balance"));

   }
      return user;

    }

    public void createNewUser(String username, String password) {
        PreparedStatement insertStatement;
        ResultSet rs;
        try {
            String insertSQL = "insert into user(username,password,balance ) values(?,?,50)";
            insertStatement = con.prepareStatement(insertSQL);
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            

            insertStatement.executeUpdate();//result set stores the results of the query
            System.out.println("You have created a new user");
        } catch (SQLException e) {
            System.out.println("Fail in create new user. Check code");
            System.out.println(e.getMessage());

        }

    }
    
    public Bottom getBottom (String bottom)
    {
        try {
            String query = "select name, price from bottoms where name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, bottom);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            Bottom dbBottom;
            
            while(resultSet.next())
            {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                
                dbBottom = new Bottom(name, price);
                
                return dbBottom;
            }
        } catch (SQLException e) {
            System.out.println("Fail to query topping.");
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public Topping getTopping (String topping)
    {
        try {
            String query = "select name, price from topping where name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, topping);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            Topping dbTopping;
            
            while(resultSet.next())
            {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                
                dbTopping = new Topping(name, price);
                
                return dbTopping;
            }
        } catch (SQLException e) {
            System.out.println("Fail to query topping.");
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public int createInvoice (Invoice invoice)
    {
        PreparedStatement insertStatement;
        try {
            String insertSQL = "insert into invoices(username) values(?)";
            insertStatement = con.prepareStatement(insertSQL);
            insertStatement.setString(1, invoice.getUsername());

            insertStatement.executeUpdate(insertSQL, 1);
            return insertStatement.getGeneratedKeys().getInt("id");
        } catch (SQLException e) {
            System.out.println("Fail in create new invoice. Check code");
            System.out.println(e.getMessage());
        }
        
        return -1;
    }
    
    public void addLineItems (ArrayList<LineItem> lineItems)
    {
        try {
            String insertSQL = "insert into lineitems(topping, bottom, quantity, username, invoiceId) values(?,?,?,?,?)";
            PreparedStatement insertStatement = con.prepareStatement(insertSQL);
            
            for(LineItem lineItem : lineItems)
            {
                insertStatement.setString(1, lineItem.getTopping().getName());
                insertStatement.setString(2, lineItem.getBottom().getName());
                insertStatement.setInt(3, lineItem.getQuantity());
                insertStatement.setString(4, lineItem.getUsername());
                insertStatement.setInt(5, lineItem.getInvoiceId());
                insertStatement.addBatch();
            }

            insertStatement.executeBatch();
            System.out.println("Line items created");
        } catch (SQLException e) {
            System.out.println("Fail in creating line items. Check code");
            System.out.println(e.getMessage());
        }
    }
}
