public class Rectangle extends Shape {
  private double width;
  private double length;
  
  public Rectangle() {
    width = 1.0;
    length = 1.0;
  }
  public Rectangle(double width, double length) {
    this.width = width;
    this.length = length;
  }
  public Rectangle(double width, double length, String color, boolean filled) {
    super(color, filled);
    setWidth(width);
    setLength(length);
  }
  
  public double getWidth() {
    return width;
  }
  public void setWidth(double width) {
    this.width = width;
  }
  public double getLength() {
    return length;
  }
  public void setLength(double length) {
    this.length = length;
  }
  public double getArea() {
    return width * length;
  }
  public double getPerimeter() {
    return 2 * (length + width);
  }
  
  public String toString() {
    return String.format("A Rectangle with width = %.2f and length = %.2f, which is a subclass of %s", width, length, super.toString());
  }
}