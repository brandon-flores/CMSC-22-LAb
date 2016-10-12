//package lab9;

public class MovableRectangle implements Movable, Drawable {
  private MovablePoint topLeft;
  private MovablePoint bottomRight;
  
  public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
    topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
    bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
  }
  
  public String toString() {
    return String.format("x1: %d, y1: %d, x2: %d, y2: %d", topLeft.x, topLeft.y, bottomRight.x, bottomRight.y);
  }
  
  public void moveUp() {
    topLeft.y -= topLeft.ySpeed;
    bottomRight.y -= bottomRight.ySpeed;
  }
  public void moveDown() {
    topLeft.y += topLeft.ySpeed;
    bottomRight.y += bottomRight.ySpeed;
  }
  public void moveLeft() {
    topLeft.x -= topLeft.xSpeed;
    bottomRight.x -= bottomRight.xSpeed;
  }
  public void moveRight() {
    topLeft.x += topLeft.xSpeed;
    bottomRight.x += bottomRight.xSpeed;
  }
  
  public void render(){
    int lengthX = bottomRight.x - topLeft.x;
    int lengthY = bottomRight.y - topLeft.y;
    for(int i = 0; i <= topLeft.y + lengthY; i++){
      if(i >= topLeft.y){
        for(int j = 0; j <= topLeft.x + lengthX; j++){
          if(j >= topLeft.x){
            System.out.print("..");
          }
          else System.out.print("  ");
        }
      }     
      System.out.println();
    }
  }

  
  public static void main(String args[]) {
    Movable rect = new MovableRectangle(10,10,30,40,5,5);
    System.out.println(rect);
    rect.render();
  }
}