import static java.lang.Math.sqrt;
public class Triangle extends Shape {
  //Challenge (Additional credits):
  //Create a class called Triangle that extends Shape. 
  //This class will have a constructor that accepts three doubles as its sides. 
  //Make sure that the sides are valid lengths of a triangle.
  //Implement the abstract methods of the superclass. 
  
  private double sideA;
  private double sideB;
  private double sideC;
  
  public Triangle(double A, double B, double C) {
    if(check(A,B,C)){
      sideA = A;
      sideB = B;
      sideC = C;
    }
    else throw new IllegalArgumentException("Invalid lengths");
  }
  
  public boolean check(double A, double B, double C){
    if(A + B > C){
      if(B + C > A){
        if(C + A > B) return true;
        else return false;
      }else return false;
    }else return false;
  }
  public double getArea(){
    double s = getPerimeter()/2;
    return Math.sqrt((s - sideA) * (s - sideB) * (s - sideC) * s);
  }
  
  public double getPerimeter() {
    return sideA + sideB + sideC;
  }
}