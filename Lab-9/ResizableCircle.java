public class ResizableCircle extends Circle implements Resizable{
  
  public ResizableCircle(double radius){
    this.radius = radius;
  }
  
  public void resize(int percent){
    double change = radius * percent/100;
    if(percent < 0) radius -= change;
    else radius += change;
  }
}