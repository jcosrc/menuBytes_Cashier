/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CashierPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natania
 */
public class DatabaseConnection implements IDatabaseConnection{

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://aws-simplified.ccnp1cnd7apy.ap-northeast-1.rds.amazonaws.com:3306/menubytes",
                    "admin", "P0Y9aixM7jUZr6Cg");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    @Override
    public String getProductNameByID(int ID) {/*This block of code is a test only. Use as reference and delete after*/
        Connection connection = null;
        String product_name = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT PRODUCT_NAME FROM product WHERE PRODUCT_ID= (?)");
        preparedStatement.setInt(1,ID);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                      product_name= resultSet.getString("product_name");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_name;
    }
    
    
}
