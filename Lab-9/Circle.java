public class Circle implements GeometricObject{
  protected double radius;
  
  public Circle(){
    radius = 1.0;
  }
  
  public Circle(double radius){
    this.radius = radius;
  }
  
  public double getPerimeter(){
    return Math.PI * 2 * radius;
  }
  
  public double getArea(){
    return Math.PI * radius * radius;
  }
  
  public String toString() {
    return String.format("radius: %.2f\nperimeter: %.2f\narea: %.2f\n", radius, getPerimeter(), getArea());
  }
}