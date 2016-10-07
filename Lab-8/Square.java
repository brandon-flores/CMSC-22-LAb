public class Square extends Rectangle {
  public Square() {
  }
  public Square(double side) {
    super(side, side);
  }
  public Square(double side, String color, boolean filled) {
    super(side, side, color, filled);
  }
  
  public double getSide() {
    return getWidth();
  }
  public void setSide(double side) {
    setWidth(side);
    setLength(side);
  }
  public void setWidth(double side){
    super.setWidth(side);
  }
  public void setLength(double side) {
    super.setLength(side);
  }
  
  public String toString() {
    return String.format("A Square with side = %.2f, which is a subclass of %s", getSide(), super.toString());
  }
  
}
