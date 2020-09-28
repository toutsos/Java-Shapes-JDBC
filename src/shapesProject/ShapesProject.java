package shapesProject;

import DAO.CircleDAO;
import DAO.Connect;
import DAO.SquareDAO;
import DAO.TriangleDAO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapesProject {
    
    private static ArrayList<Shape> shapes = new ArrayList<>();
    private Comparators sortArea = new Comparators(shapes);

    public static void main(String[] args) {
        Shape.count=0;
        Scanner keys = new Scanner(System.in);
        ShapesProject newApp = new ShapesProject();
        try {                                   //open connection to DB
            Connection con=Connect.connectionOpen();
            newApp.firstMenu(keys,con);
            Connect.connectionClose(con);
        } catch (Exception e) {
            System.out.println(e);                  
        }//try - catch
        keys.close(); 
    }//main

    
    public void firstMenu(Scanner keys,Connection con) throws SQLException {
        int firstMenu = 0;
        while (firstMenu != 4) {
            try {
                System.out.println("---------------------------------------");
                System.out.println("To LOAD from DB and VIEW all shapes press 1");
                System.out.println("To create new shape press 2");
                System.out.println("To write shapes into txt file press 3");
                System.out.println("To sort shapes press 4");
                System.out.println("To delete shapes press 5");
                System.out.println("To exit press 6");
                System.out.println("---------------------------------------");
                firstMenu = keys.nextInt();
                if (firstMenu == 1) {
                    showAllShapes(shapes,con);
                } else if (firstMenu == 2) {
                    secondMenu(keys,con);
                } else if (firstMenu == 3) {
                    createFile();
                } else if (firstMenu == 6) {
                    break;
                }else if(firstMenu == 4){
                    sortMenu(keys,con);
                }else if(firstMenu == 5){
                    secondMenuDelete(keys,con);
                }else {
                    System.out.println("Wrong number please, try again!");
                    firstMenu = keys.nextInt();
                }//else
            } catch (InputMismatchException e) {
                System.out.println("Only numbers allowed!");
                System.out.println("Try again!");
                keys.next();
            }//catch
        }//while
    }//firstMenu

    public void showAllShapes(ArrayList<Shape> shapes,Connection con) throws SQLException {
        shapes.removeAll(shapes);
        SquareDAO.selectSquares(con,shapes);
        CircleDAO.selectCircles(con, shapes);
        TriangleDAO.selectTriangles(con, shapes);
        if (shapes.size() != 0) {
            System.out.println("We have: " + shapes.size() + " shapes saved!");
        }//if
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).toString());
        }//for
        if (shapes.isEmpty()) {
            System.out.println("Our shape-list is empty! Add some shapes!");
        }//if
    }//showAllShapes

    public void secondMenu(Scanner keys,Connection con) throws SQLException {
        int secondMenu = 0;
        while (secondMenu != 4) {
            try {
                System.out.println("---------------------------------------");
                System.out.println("To create Square press 1");
                System.out.println("To create Triangle press 2");
                System.out.println("To create Circle press 3");
                System.out.println("To return press 4");
                System.out.println("---------------------------------------");
                secondMenu = keys.nextInt();
                if (secondMenu == 1) {
                    createSquare(con,keys);
                    break;
                } else if (secondMenu == 2) {
                    createTriangle(keys,con);
                    break;
                } else if (secondMenu == 3) {
                    createCircle(keys,con);
                    break;
                } else if (secondMenu == 4) {
                    continue;
                } else {
                    System.out.println("Wrong number please, try again!");
                    secondMenu = keys.nextInt();
                }//else
            } catch (InputMismatchException e) {
                System.out.println("Only numbers allowed!");
                System.out.println("Try again!");
                keys.next();
            }//try-catch
        }//while
    }//secondMenu

    public void createSquare(Connection con,Scanner keys) throws SQLException {
        try {
            System.out.println("Give me the name of your Shape");
            keys.nextLine();
            String name = keys.nextLine();
            System.out.println("Give me the side of your square");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    int side = keys.nextInt();
                    SquareDAO.insertSquare(con,shapes,name,side);
                    //Square newSquare = new Square(name, side);
                    //shapes.add(newSquare);
                    Shape.count++;
                    break;
                } else {
                    System.out.println("We need an integer!, try again!");
                    keys.next();
                }//else
            }//while

        } catch (InputMismatchException e) {
            System.out.println("Something went wrong please try again!");
            System.out.println("Please add Integer for side!");
            //try-catch
        } catch (RuntimeException s) {
        }//try-catch  
    }//createSquare

    public void createTriangle(Scanner keys, Connection con) throws SQLException{
        try {
            int base = 0;
            int sideA = 0;
            int sideB = 0;
            int height = 0;
            System.out.println("Give me the name of your Shape");
            keys.nextLine();
            String name = keys.nextLine();
            System.out.println("Give me the base of your triangle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    base = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for base");
                    keys.next();
                }//else
            }//while
            System.out.println("Give me the side 'A' of your triangle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    sideA = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for sideA");
                    keys.next();
                }//else
            }//while    
            System.out.println("Give me the side 'B' of your triangle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    sideB = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for side B");
                    keys.next();
                }//else
            }//while
            System.out.println("Give me the height of your triangle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    height = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for height");
                    keys.next();
                }//else
            }//while
            TriangleDAO.insertTriangle(con, shapes, name, base, sideA, sideB, height);
//            Triangle newTriangle = new Triangle(name, base, sideA, sideB, height);
//            shapes.add(newTriangle);
            Shape.count++;
            System.out.println("Triangle added!");
        } catch (InputMismatchException e) {
            System.out.println("Something went wrong please try again!");
        }//try-catch
    }//createTriangle   

    public void createCircle(Scanner keys,Connection con) throws SQLException {
        try {
            int radius = 0;
            int xPoint = 0;
            int yPoint = 0;
            System.out.println("Give me the name of your Shape");
            keys.nextLine();
            String name = keys.nextLine();
            System.out.println("Give me the radius of your circle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    radius = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for radius");
                    keys.next();
                }//else
            }//while
            System.out.println("Give me the X point of your circle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    xPoint = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for X point");
                    keys.next();
                }//else
            }//while
            System.out.println("Give me the Y point of your circle");
            while (keys.hasNext()) {
                if (keys.hasNextInt()) {
                    yPoint = keys.nextInt();
                    break;
                } else {
                    System.out.println("Please add integer for Y point");
                    keys.next();
                }//else
            }//while
            CircleDAO.insertCircle(con, shapes, name, radius, xPoint, yPoint);
//            Point newPoint = new Point(xPoint, yPoint);
//            Circle newCircle = new Circle(name, radius, newPoint);
//            shapes.add(newCircle);
            Shape.count++;
            System.out.println("Circle added!");
        } catch (InputMismatchException e) {
            System.out.println("Something went wrong please try again!");
        }//try-catch
    }//createCircle   

    public void createFile() {
       try {
            PrintWriter newPrintWriter = new PrintWriter("shapes.txt");
            for (int i = 0; i < shapes.size(); i++) {
                newPrintWriter.println(shapes.get(i).toString());
            }//for
            newPrintWriter.close();
            System.out.println("File successfully created!");
        } catch (Exception e) {
            System.out.println("We had an exception: " + e);
        }//try-catch
    }//createFile

    public void sortMenu(Scanner keys,Connection con) throws SQLException{
            int sortMenuFlag = 0;
            while (sortMenuFlag!=4){
                try {
                    System.out.println("To sort shapes with their AREA size press 1");
                    System.out.println("To sort shapes with their PERIMETES press 2");
                    System.out.println("To exit press 3");
                    sortMenuFlag =keys.nextInt();
                    if(sortMenuFlag==1){
                        Collections.sort(shapes,sortArea.com1); //sort with area
                        for (int i = 0; i < shapes.size(); i++) {
                             System.out.println(shapes.get(i).toString()); //print sorted
                        }//for
                        System.out.println("---------------------------------------");
                    }else if(sortMenuFlag==2){
                        Collections.sort(shapes,sortArea.com2);
                        for (int i = 0; i < shapes.size(); i++) {
                             System.out.println(shapes.get(i).toString()); //print sorted
                        }//for
                        System.out.println("---------------------------------------");
                    }else if(sortMenuFlag==3){
                        firstMenu(keys,con);                                                           //IS THERE A BETTER WAY????
    //                      return;
                    }else{
                        System.out.println("Wrong number! Try again!");
                        sortMenuFlag = keys.nextInt();
                        System.out.println("---------------------------------------");
                    }//else
               
                } catch (InputMismatchException e) {
                    System.out.println("Give me a number please.");
                    keys.next();
                    System.out.println("---------------------------------------");
                }//try-catch
            }//while
    }//sort
    
    public void secondMenuDelete(Scanner keys,Connection con) throws SQLException {
        int secondMenu = 0;
        while (secondMenu != 4) {
            try {
                System.out.println("---------------------------------------");
                System.out.println("To delete Square press 1");
                System.out.println("To delete Triangle press 2");
                System.out.println("To delete Circle press 3");
                System.out.println("To return press 4");
                System.out.println("---------------------------------------");
                secondMenu = keys.nextInt();
                if (secondMenu == 1) {
                    System.out.println("Give me tha name of the Square you want to delete");
                    String deletedName = keys.next();
                    SquareDAO.deleteSquare(con,deletedName);
                    break;
                } else if (secondMenu == 2) {
                    System.out.println("Give me tha name of the Triangle you want to delete");
                    String deletedName = keys.next();
                    TriangleDAO.deleteTriangle(con,deletedName);
                    break;
                } else if (secondMenu == 3) {
                    System.out.println("Give me tha name of the Circle you want to delete");
                    String deletedName = keys.next();
                    CircleDAO.deleteCircle(con,deletedName);
                    break;
                } else if (secondMenu == 4) {
                    continue;
                } else {
                    System.out.println("Wrong number please, try again!");
                    secondMenu = keys.nextInt();
                }//else
            } catch (InputMismatchException e) {
                System.out.println("Only numbers allowed!");
                System.out.println("Try again!");
                keys.next();
            }//try-catch
        }//while
    }//secondMenu
    
    
  
}//class