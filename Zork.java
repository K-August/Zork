public class Zork
{
  static class PlayerPostion
  {
    private int x;
    private int y;
    private String position;
    
    PlayerPosition()
    {
      x = 0;
      y = 0;
    }
    
    private void GetPosition()
    {
      return position = String.format("(%s, %s)", this.x, this.y);
    }
  }
  
  public static void main(String[] args)
  {
    // Stuff
  }
}
