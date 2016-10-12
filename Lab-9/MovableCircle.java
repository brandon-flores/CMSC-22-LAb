//package lab9;

public class MovableCircle implements Movable {
  private int radius;
  private MovablePoint center;
  
  public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
    center = new MovablePoint(x, y, xSpeed, ySpeed);
    this.radius = radius;
  }
  
  public String toString() {
    return String.format("radius: %d, x: %d, y: %d", radius, center.x, center.y);
  }
  
  public void moveUp() {
    center.y -= center.ySpeed;
  }
  public void moveDown() {
    center.y += center.ySpeed;
  }
  public void moveLeft() {
    center.x -= center.xSpeed;
  }
  public void moveRight() {
    center.x += center.xSpeed;
  }
  
  public void render(){
    int startY = center.y - radius, startX = center.x - radius;
    boolean flag = true;
    int dia = radius * 2 + 1, ctr = 0;
    for(int i = 0; i < startY + dia; i++){
      if(i >= startY){
        if(i <= center.y){
          for(int j = 0; j < startX + dia; j++){
            if(j >= (startX + radius) - ctr && j <= (startX + radius) + ctr){
              System.out.print("..");
            }
            else System.out.print("  ");
          }
        }
        else{
          if(flag) {
            ctr = 1;
            flag = false;
          }
          for(int j = 0; j < startX + dia; j++){
            if(j >= startX + ctr && j < startX + dia - ctr){
              System.out.print("..");
            }
            else System.out.print("  ");
          }
        }
        ctr++;
      }
      System.out.println();
    }
  }
  
  public static void main(String args[]) {
    Movable circ = new MovableCircle(10,10,5,5,7);
    System.out.println(circ);
    circ.render();
  }
}