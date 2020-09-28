/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
    
    public static void insertSquare(Connection con,ArrayList shapes,String name,int side) throws SQLException {
        String sql = "INSERT INTO squares (name,side) VALUES (?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setInt(2, side);
        pstm.executeUpdate();
        Square newSquare = new Square(name, side);
        //shapes.add(newSquare);
    }//insertSquare
    
    public static void deleteSquare(Connection con,String name)throws SQLException{
        String sql = "DELETE FROM squares WHERE name=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.executeUpdate();
    }//deleteSquare
   
}//class
