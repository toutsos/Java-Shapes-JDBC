
package shapesProject;

import java.util.Objects;

public abstract class Shape { //δεν μπορει αν δημιουργήσει αντικέιμενα
    
    private String name; //can be seen only inside same package
    public static int count;
    
    //CONSTRUCTORS//
    public Shape(String name) {
        this.name = name;
    }//constructor

    //GETTERS-SETTERS//
    public String getName() {
        return name;
    }//getName

    public void setName(String name) {
        this.name = name;
    }//setName
    
    public abstract double getArea();
    public abstract double getPerimeter();
    
    @Override
    public String toString(){
        return "Shape{" + "name: "+name+" }";
    }//toString

    @Override
    public int hashCode() {
        int hash = 7;
//        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Shape other = (Shape) obj;
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        return true;
//    }
    
    
       
}//class
