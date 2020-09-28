
package shapesProject;

import java.util.ArrayList;
import java.util.Comparator;

public class Comparators {
    
    private ArrayList<Shape> shapeComparator; //insert list to comparator
 
    // CONSTRUCTOR //
    public Comparators(ArrayList<Shape> shapeComparator) {
        this.shapeComparator = shapeComparator;
    }//constructor

    public Comparators() {
    }//constructor
    
    //METHODS//
    
    Comparator<Shape> com1 = new Comparator<Shape>(){ //sort area
        @Override
        public int compare(Shape mov1, Shape mov2) {
           if(mov1.getArea()>mov2.getArea()){
               return -1;
           }else
               return 1;
        }
    };
    
    Comparator<Shape> com2 = new Comparator<Shape>(){ //sort perimeter
        @Override
        public int compare(Shape mov1, Shape mov2) {
           if(mov1.getPerimeter()>mov2.getPerimeter()){
               return -1;
           }else
               return 1;
        }
    };
    
    }//class

