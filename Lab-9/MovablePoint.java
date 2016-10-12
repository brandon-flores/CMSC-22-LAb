//package lab9;

public class MovablePoint implements Movable {
  int x, y, xSpeed, ySpeed;
  
  public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
    this.x = x;
    this.y = y;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }
  
  public String toString() {
    return String.format("x: %d, y: %d", x, y);
  }
  
  public void moveUp() {
    y -= ySpeed;
  }
  public void moveDown() {
    y += ySpeed;
  }
  public void moveLeft() {
    x -= xSpeed;
  }
  public void moveRight() {
    x += xSpeed;
  }
  public void render(){
    for(int i = 0; i < y; i++){
     System.out.println();
   }
   for(int j = 0; j < x; j++){
     System.out.print("  ");
   }
   System.out.println(".");
  }
  
  public static void main(String args[]) {
    Movable pnt = new MovablePoint(4,4,5,5);
    System.out.println(pnt);
    pnt.render();
  }
}