import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ShapeTest extends TestCase {
  
  public static void main(String[] args) {
    Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
    System.out.println(s1);                    // which version? Circle
    System.out.println(s1.getArea());          // which version? Circle
    System.out.println(s1.getPerimeter());     // which version? Circle
    System.out.println(s1.getColor());
    System.out.println(s1.isFilled());
    System.out.println(s1.getRadius()); /* Should be downcasted since there is no abstract function getRadius in abstract class Shape
                                         * Didn't create an abstract function getRadius in abstract class Shape since not all Shape has a radius
                                         * Correct : System.out.println(((Circle)s1).getRadius());
                                         */
    
    Circle c1 = (Circle)s1;                   // Downcast back to Circle
    System.out.println(c1);
    System.out.println(c1.getArea());
    System.out.println(c1.getPerimeter());
    System.out.println(c1.getColor());
    System.out.println(c1.isFilled());
    System.out.println(c1.getRadius());
    
    //Shape s2 = new Shape(); shape cannot be instantiated since it's an abstract class
    
    Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast
    System.out.println(s3);
    System.out.println(s3.getArea());
    System.out.println(s3.getPerimeter());
    System.out.println(s3.getColor());
    System.out.println(s3.getLength());/* Should be downcasted since there is no abstract function getLength in abstract class Shape
                                        * Didn't create an abstract function getLength in abstract class Shape since not all Shape has a length
                                        * Correct : System.out.println(((Rectangle)s3).getLength());
                                        */
    
    Rectangle r1 = (Rectangle)s3;   // downcast
    System.out.println(r1);
    System.out.println(r1.getArea());
    System.out.println(r1.getColor());
    System.out.println(r1.getLength());
    
    Shape s4 = new Square(6.6);     // Upcast
    System.out.println(s4);
    System.out.println(s4.getArea());
    System.out.println(s4.getColor());
    System.out.println(s4.getSide());  /* Should be downcasted since there is no abstract function getSide in abstract class Shape
                                        * Didn't create an abstract function getSide in abstract class Shape since not all Shape has a side
                                        * Correct : System.out.println(((Square)s4).getSide());
                                        */
    
// Take note that we downcast Shape s4 to Rectangle, 
//  which is a superclass of Square, instead of Square
    Rectangle r2 = (Rectangle)s4;
    System.out.println(r2);
    System.out.println(r2.getArea());
    System.out.println(r2.getColor());
    System.out.println(r2.getSide());  /* Should be downcasted since there is no abstract function getSide in class Rectangle
                                        * Didn't create an abstract function getSide in class Rectangle since sides of a rectangle varies
                                        * Correct : System.out.println(((Square)r2).getSide());
                                        */
    System.out.println(r2.getLength());
    
// Downcast Rectangle r2 to Square
    Square sq1 = (Square)r2;
    System.out.println(sq1);
    System.out.println(sq1.getArea());
    System.out.println(sq1.getColor());
    System.out.println(sq1.getSide());
    System.out.println(sq1.getLength());
  }
  
}


  //Challenge (Additional credits):
  //Create a class called Triangle that extends Shape. 
  //This class will have a constructor that accepts three doubles as its sides. 
  //Make sure that the sides are valid lengths of a triangle.
  //Implement the abstract methods of the superclass. 
