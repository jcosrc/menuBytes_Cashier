/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashierPackage;

import java.sql.Connection;

/**
 *
 * @author Natania
 */
public interface IDatabaseConnection {
    //common methods
    //for db connection
    
    public Connection getConnection();
    
    
    public String getProductNameByID(int ID);/*This line is a test only. Use as reference and delete after*/
}
