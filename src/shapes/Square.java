
package shapes;

import shapesProject.Shape;

public class Square extends Shape{
    
    private int side;

    public Square(String name, int side) {
        super(name);
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

//METHODS

@Override
public double getArea(){
    return this.side*this.side;
}

@Override
public double getPerimeter(){
    return this.side*4;
}

@Override
public String toString(){
    return "Square: {Name:" +getName()+" ,Side: "+side+", Perimeter: "+getPerimeter()+", Area: "+getArea()+" }";
}
    
    
    
}//class
