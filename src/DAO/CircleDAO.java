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
import shapes.Circle;
import shapes.Point;

/**
 *
 * @author a.toutsios
 */
public class CircleDAO {
    public static void selectCircles(Connection con,ArrayList shapes )throws SQLException{
        String sql = "SELECT name , radius , x , y FROM circles";
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            String name = rs.getString("name");
            int radius = rs.getInt("radius");
            int x = rs.getInt("x");
            int y = rs.getInt("y");
            Point newPoint = new Point(x,y);
            Circle newCirlce = new Circle(name, radius,newPoint);
            shapes.add(newCirlce);
        }//while
    }//select squares
    
    public static void insertCircle(Connection con,ArrayList shapes,String name,int radius,int x,int y) {
        try {
            String sql = "INSERT INTO circles (name,radius,x,y) VALUES (?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, radius);
            pstm.setInt(3, x);
            pstm.setInt(4, y);
            pstm.executeUpdate();
            Point newPoint = new Point(x,y);
            Circle newCircle = new Circle(name, radius, newPoint);
            shapes.add(newCircle);  
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }//insertSquare
    
    public static void deleteCircle(Connection con,String name)throws SQLException{
        try {
            String sql = "DELETE FROM circles WHERE name=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }//deleteSquare
    
    
}//class
