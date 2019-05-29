
public class PlayerTestV2
{

   public static void main(String[] args)
   {
      PlayerV2 p1 = new PlayerV2(13, "Guard", "Wolf Lesowzsky", "");
      PlayerV2 p2 = new PlayerV2(16, "Guard", "Wolf Wolfovic", "");
      PlayerV2 p3 = new PlayerV2(16, "Guard", "Wolf Wolfovic", "");
      p1.setPlayer("Karl Karlovic", "Goalkeeper", 12);
      
      System.out.println(p1.getName()+p1.getNote()+p1.getNumber()+p1.getPosition());
      System.out.println(p1.toString());
      System.out.println(p1.copy());
      System.out.println(p1.equals(p2));
      System.out.println(p1.equals(p2));
      System.out.println(p2.equals(p3));
   }

}
