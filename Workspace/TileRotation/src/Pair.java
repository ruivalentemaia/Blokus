
public class Pair {
  public int x,y;
  
  Pair (int x1, int y1) {
    this.x = x1;
    this.y = y1;
  }
  
  public boolean equals (Object o) {
    Pair p = (Pair) o;
        if (p.x == this.x && p.y == this.y) 
          return true;
        
        return false;
    }
}