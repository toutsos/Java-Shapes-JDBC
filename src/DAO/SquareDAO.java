/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import shapes.Square;

/**
 *
 * @author a.toutsios
 */
public class SquareDAO {
    
    public static void selectSquares(Connection con,ArrayList shapes )throws SQLException{
        String sql = "SELECT name , side FROM squares";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            String name = rs.getString("name");
            int side = rs.getInt("side");
            Square newSquare = new Square(name, side);
            shapes.add(newSquare);
        }//while
    }//select squares
    
    public static void insertSquare(Connection con,ArrayList shapes,String name,int side){
        try {
            String sql = "INSERT INTO squares (name,side) VALUES (?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, side);
            int numberOfRows = pstm.executeUpdate();
            if(numberOfRows == 1 ){
                System.out.println("Square added successfully!");
                Square newSquare = new Square(name, side);
                shapes.add(newSquare);
            }else{
                System.out.println("Try again with another name");
            } 
        } catch (SQLException e) {
//            System.out.println("This name already exists, try a new one!");
                System.out.println(e);
        }
       
        
    }//insertSquare
    
    public static void deleteSquare(Connection con,String name){
        try {
            String sql = "DELETE FROM squares WHERE name=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            int number = pstm.executeUpdate();
            if(number==1){
                System.out.println("square deleted");
            }else{
                System.out.println("There is no square with that name");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//deleteSquare
   
}//class
