public abstract class Shape {
  private boolean filled;
  private String color;
  
  public abstract double getArea();
  public abstract double getPerimeter();
  
  //default constructor
  public Shape() {
    color = "green";
    filled = true;
  }
  public Shape(String color, boolean filled) {
    setColor(color);
    setFilled(filled);
  }
  //getter-setter
  public String getColor() {
    return color;
  }
  public boolean isFilled() {
    return filled;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  //end
  public String toString(){
    String valFilled = (filled == true) ? "filled" : "not filled"; 
    return String.format("A shape with a color of %s and %s", color, valFilled);
  }
  
}