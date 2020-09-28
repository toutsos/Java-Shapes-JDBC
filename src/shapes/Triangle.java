
package shapes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import shapesProject.Shape;

public class Triangle extends Shape{
    private int sideA;
    private int sideB;
    private int sideC;
    private int height;

    //CONSTRUCTOR
    public Triangle(String name, int sideA, int sideB, int sideC, int height) {
        super(name);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
    }

    
    
    //GETTERS SETTERS

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

//METHODS
    
    public double getArea(){
        double dHeight = (double)(this.height);
        double dSideA = (double)(this.sideA);
        double area=((dSideA*dHeight*dHeight)/2);
        BigDecimal bd = new BigDecimal(area).setScale(2,RoundingMode.HALF_UP);
        double areaReturn = bd.doubleValue();
        return areaReturn;
    }
 
    public double getPerimeter(){
        return this.sideA+this.sideB+this.sideC;
    }
    
    @Override
    public String toString(){
        return "Triangle: {Name:" +getName()+" ,Side A: "+sideA+" ,SideB: "+sideB+" ,Side C: "+sideC+" ,Height: "+height+", Perimeter: "+getPerimeter()+", Area: "+getArea()+" }";
    }
    
}//class
