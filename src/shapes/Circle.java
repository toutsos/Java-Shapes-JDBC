
package shapes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import shapesProject.Shape;

public class Circle extends Shape {
    
    private int radius;
    private Point point;
    //This is a test
    //CONSTRUCTORS
    public Circle(String name,int radius, Point newPoint ) {
        super(name);
        this.radius = radius;
        this.point = newPoint;
    }
    
    
    //GETTERS-SETTERS

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    //METHODS
    @Override
    public double getArea(){
            double area = Math.PI*Math.pow(this.radius,2);
            BigDecimal bd = new BigDecimal(area).setScale(2,RoundingMode.HALF_UP);
            double areaReturn = bd.doubleValue();
            return areaReturn;
    }
    
    public double getPerimeter(){
        double perimeter = 2*Math.PI*this.radius;
        BigDecimal bd = new BigDecimal(perimeter).setScale(2,RoundingMode.HALF_UP);
        double perimeterReturn = bd.doubleValue();
        return perimeterReturn;
    }
    
    @Override
    public String toString(){
        return "Circle: {Name:" +getName()+" ,Radius: "+radius+", Point("+point.getX()+","+point.getY()+"), Perimeter: "+getPerimeter()+", Area: "+getArea()+" }";
    }
    
}//class
