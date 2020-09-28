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
import shapes.Triangle;

/**
 *
 * @author a.toutsios
 */
public class TriangleDAO {
    
     public static void selectTriangles(Connection con,ArrayList shapes )throws SQLException{
        String sql = "SELECT name , base , sideA , sideB, height FROM triangles";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            String name = rs.getString("name");
            int base = rs.getInt("base");
            int sideA = rs.getInt("sideA");
            int sideB = rs.getInt("sideB");
            int height = rs.getInt("height");
            Triangle newTriangle = new Triangle(name, base,sideA,sideB,height);
            shapes.add(newTriangle);
        }//while
    }//select squares
    
    public static void insertTriangle(Connection con,ArrayList shapes,String name,int base,int sideA,int sideB,int height) throws SQLException {
        String sql = "INSERT INTO triangles (name,base,sideA,sideB,height) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setInt(2, base);
        pstm.executeUpdate();
        Triangle newTriangle = new Triangle(name, base, sideA,sideB,height);
        shapes.add(newTriangle);
    }//insertSquare
    
    public static void deleteTriangle(Connection con,String name)throws SQLException{
        String sql = "DELETE FROM triangles WHERE name=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.executeUpdate();
    }//deleteSquare
    
}//class
