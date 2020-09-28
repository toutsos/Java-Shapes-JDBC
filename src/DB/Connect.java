/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author a.toutsios
 */
public class Connect {
    static Connection con;   
    
    public static void connectionOpen()throws ClassNotFoundException,SQLException,InstantiationException,IllegalAccessException{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shapes?useSSL=false", "root", "root"); 
            if(con!=null){
                System.out.println("Connected to database");
               // return con;
            }else{
                System.out.println("Failed to connect to database");
            } 
    }
    
    
}//main

