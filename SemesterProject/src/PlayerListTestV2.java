

public class PlayerListTestV2
{

   public static void main(String[] args)
   {
      PlayerV2 p1 = new PlayerV2(13, "John", "Guard", "lol");
      PlayerV2 p2 = new PlayerV2(13, "John", "Guard", "");
      PlayerV2 p3 = new PlayerV2(13, "John", "Guard", "lol");
      PlayerV2 p4 = new PlayerV2(13, "John", "Guard", "");
      PlayerListV2 pl1 = new PlayerListV2();
      
      pl1.addPlayer(p1);
      pl1.addPlayer(p2);
      pl1.addPlayer(p3);
      pl1.addPlayer(p4);
      System.out.println(pl1.toString());

      System.out.println(pl1.getAllPlayers());
      System.out.println(pl1.getNoteFrom(0));
   }

}
