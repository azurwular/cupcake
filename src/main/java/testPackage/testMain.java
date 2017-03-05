/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import DataAccessLayer.DataMapper;
import Model.User;
import java.sql.SQLException;

/**
 *
 * @author Julian
 */
public class testMain {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args)throws SQLException {
        DataMapper dm = new DataMapper();
        try{
       dm.createNewUser("test", "test");
        }
        catch(NullPointerException e ){System.out.println("catch");}
       
    }
    
}
